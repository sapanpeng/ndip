package com.tenghong.ndip.service.his.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenghong.ndip.core.constants.HisOmsEnum;
import com.tenghong.ndip.mapper.his.HisCafeteriaMapper;
import com.tenghong.ndip.mapper.his.HisOmsDetailsEntityMapper;
import com.tenghong.ndip.mapper.his.HisOmsEntityMapper;
import com.tenghong.ndip.mapper.his.HisOmsMapper;
import com.tenghong.ndip.mapper.his.HisOmsStatusMapper;
import com.tenghong.ndip.mapper.his.HisPatientMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletRecordsMapper;
import com.tenghong.ndip.model.bo.DeliverOrderBO;
import com.tenghong.ndip.model.bo.ReceiveOrderBO;
import com.tenghong.ndip.model.command.OrderReportCommand;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisOmsDetailsEntity;
import com.tenghong.ndip.model.his.HisOmsDetailsEntityExample;
import com.tenghong.ndip.model.his.HisOmsEntity;
import com.tenghong.ndip.model.his.HisOmsEntityExample;
import com.tenghong.ndip.model.his.HisOmsStatus;
import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.model.his.HisPatientWallet;
import com.tenghong.ndip.model.his.HisPatientWalletRecords;
import com.tenghong.ndip.model.vo.DeliverOrderVO;
import com.tenghong.ndip.model.vo.ReceiveOrderVO;
import com.tenghong.ndip.model.vo.report.WardIncomeVo;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.utils.DateUtil;
import com.tenghong.ndip.utils.SqlMapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:26 2018/6/23
 */
@Service
public class OmsServiceImpl implements OmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmsServiceImpl.class);

    @Autowired
    private HisOmsMapper omsMapper;

    @Autowired
    private HisPatientWalletMapper patientWalletMapper;

    @Autowired
    private HisPatientWalletRecordsMapper patientWalletRecordsMapper;

    @Autowired
    private HisOmsStatusMapper omsStatusMapper;

    @Autowired
    private HisCafeteriaMapper hisCafeteriaMapper;

    @Autowired
    private HisOmsEntityMapper hisOmsEntityMapper;

    @Autowired
    private HisOmsDetailsEntityMapper hisOmsDetailsEntityMapper;

    @Autowired
    private HisPatientMapper hisPatientMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void save(HisOms oms) {
        omsMapper.insertSelective(oms);
    }

    @Override
    public List<HisOms> getDataGrip(List<Integer> list, Integer userId) {
        return omsMapper.findDataByIdList(list, userId);
    }

    @Override
    @Transactional
    public void refreshOms(Integer mealTimesId) {
        try {
            List<HisOms> omsList = omsMapper.findDataByIdMealId(mealTimesId);
            for (HisOms oms : omsList) {
                //刷新病人钱包
                HisPatientWallet wallet = patientWalletMapper.selectByPatientId(oms.getPatientId());
                wallet.setTotalWallet(wallet.getTotalWallet() - oms.getPrice());
                patientWalletMapper.updateByPrimaryKey(wallet);

                //记录病人钱包变动
                HisPatientWalletRecords records = new HisPatientWalletRecords();
                records.setPatientId(oms.getPatientId());
                records.setFlag(0);
                records.setCurrentAmount(oms.getPrice());
                records.setMemo("系统订餐扣减");
                records.setCreateTime(new Date());
                patientWalletRecordsMapper.insertSelective(records);

                //刷新订单
                oms.setOmsType(HisOmsEnum.PAY.getType());
                omsMapper.updateByPrimaryKeySelective(oms);

                //记录订单状态
                HisOmsStatus status = new HisOmsStatus();
                status.setOrderId(oms.getId());
                status.setStatus(HisOmsEnum.PAY.getType());
                status.setCreateTime(new Date());
                omsStatusMapper.insertSelective(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Server Exception：{}", e);
        }

    }

    @Override
    public ReceiveOrderVO selectReceiveDetail(OrderReportCommand command) {
        HisCafeteria hisCafeteria = hisCafeteriaMapper.selectByPrimaryKey(command.getCafeteriaId());
        HisOmsEntityExample example = new HisOmsEntityExample();
        HisOmsEntityExample.Criteria criteria = example.createCriteria();
        if (command.getDate() != null) {
            criteria.andDiningTimeEqualTo(DateUtil.parseDate(command.getDate()));
        }
        if (command.getCafeteriaId() != null) {
            criteria.andCafeteriaIdEqualTo(command.getCafeteriaId());
        }
        if (command.getWardId() != null) {
            criteria.andWardIdEqualTo(command.getWardId());
        }
        if (command.getMealId() != null) {
            criteria.andMealIdEqualTo(command.getMealTimesId());
        }
        List<HisOmsEntity> orders = hisOmsEntityMapper.selectByExample(example);
        if (orders.size() == 0)
            return new ReceiveOrderVO();
        List<Integer> idList = new ArrayList<>(orders.size());
        for (HisOmsEntity each : orders) {
            idList.add(each.getId());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ovenId", command.getOvenId());
        map.put("idList", idList);

        PageHelper.startPage(command.getPageNo(), command.getPageSize());
        List<ReceiveOrderBO> result = hisOmsDetailsEntityMapper.selectByGroup(map);
        PageInfo<ReceiveOrderBO> pageInfo = new PageInfo<>(result);

        ReceiveOrderVO vo = new ReceiveOrderVO();
        vo.setWardName(orders.get(0).getWardName());
        vo.setDate(command.getDate());
        vo.setPageCount((int) pageInfo.getTotal());
        vo.setList(pageInfo.getList());
        vo.setTitle(hisCafeteria.getCafeteriaName().concat("领餐单"));
        return vo;
    }

    @Override
    public DeliverOrderVO selectDeliverDetail(OrderReportCommand command) {
        DeliverOrderVO result = new DeliverOrderVO();
        result.setDate(command.getDate());
        HisCafeteria hisCafeteria = hisCafeteriaMapper.selectByPrimaryKey(command.getCafeteriaId());
        if (hisCafeteria != null) {
            result.setTitle(hisCafeteria.getCafeteriaName().concat("送餐单"));
        }
        HisOmsEntityExample example = new HisOmsEntityExample();
        HisOmsEntityExample.Criteria criteria = example.createCriteria();
        if (command.getDate() != null) {
            criteria.andDiningTimeEqualTo(DateUtil.parseDate(command.getDate()));
        }
        if (command.getCafeteriaId() != null) {
            criteria.andCafeteriaIdEqualTo(command.getCafeteriaId());
        }
        if (command.getWardId() != null) {
            criteria.andWardIdEqualTo(command.getWardId());
        }
        if (command.getMealId() != null) {
            criteria.andMealIdEqualTo(command.getMealTimesId());
        }
        List<HisOmsEntity> orders = hisOmsEntityMapper.selectByExample(example);
        if (orders.size() == 0) {
            return result;
        }
        result.setWardName(orders.get(0).getWardName());
        List<Integer> idList = new ArrayList<>(orders.size());
        HashMap<Integer, HisOmsEntity> orderMap = new HashMap<>();
        for (HisOmsEntity each : orders) {
            idList.add(each.getId());
            orderMap.put(each.getId(),each);
        }
        HisOmsDetailsEntityExample detailExample = new HisOmsDetailsEntityExample();
        HisOmsDetailsEntityExample.Criteria detailCriteria = detailExample.createCriteria();
        detailCriteria.andOmsIdIn(idList);
        if (command.getOvenId() != null) {
            detailCriteria.andOvenIdEqualTo(command.getOvenId());
        }
        PageHelper.startPage(command.getPageNo(),command.getPageSize());
        List<HisOmsDetailsEntity> list = hisOmsDetailsEntityMapper.selectByExample(detailExample);
        PageInfo<HisOmsDetailsEntity> pageInfo = new PageInfo<>(list);
        ArrayList<DeliverOrderBO> pageList = new ArrayList<>();
        for (HisOmsDetailsEntity item : list) {
            DeliverOrderBO each = new DeliverOrderBO();
            HisOmsEntity order = orderMap.get(item.getOmsId());
            HisPatient hisPatient = hisPatientMapper.selectByPatientId(String.valueOf(order.getPatientId()));
            each.setName(hisPatient.getName());
            each.setBedNo(hisPatient.getBedNo());
            each.setNumber(item.getGoalNum());
            each.setMemo(item.getMemo());
            each.setOvenName(item.getOvenName());
            each.setType(item.getGoalType());
            each.setUser(order.getUserName());
            each.setHisNo(hisPatient.getInpNo());
            pageList.add(each);
        }
        result.setList(pageList);
        result.setPageCount(((int) pageInfo.getTotal()));
        return result;
    }

    @Override
    public void getData(com.tenghong.ndip.utils.PageInfo pageInfo) {
        pageInfo.setRows(omsMapper.findPageCondition(pageInfo));
        pageInfo.setRecords(omsMapper.findPageCount(pageInfo));
    }

    @Override
    public HisOms getOne(Integer id) {
        return omsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(HisOms oms) {
        omsMapper.updateByPrimaryKeySelective(oms);
    }

    @Override
    public Double getYesterdayReward(Integer cafeteriaId) {
        String sql = "select sum(oms.price) from his_oms oms join  his_patient patient ON oms.patient_id = patient.patient_id "
        		+ " JOIN his_inpatient_area ward ON ward.ward_code = patient.ward_code  JOIN his_relation relation"
        		+ " ON ward.id = relation.ward_id where oms.oms_type = 2 and relation.cafeteria_id= " + cafeteriaId
        		+ "  and DATE_FORMAT(dining_time,'%Y-%m-%d') = DATE_FORMAT(DATE_SUB(curdate(),INTERVAL +  1 DAY),'%Y-%m-%d')";
        Double ret =  sqlMapper.selectOne(sql,double.class);
        if (null == ret)
            return 0.00;
        return ret;
    }

    @Override
    public void getWardIncome(com.tenghong.ndip.utils.PageInfo pageInfo) {
        Map<String,Object> map = pageInfo.getCondition();
        List<WardIncomeVo> list = omsMapper.findIncome(pageInfo);
        for (WardIncomeVo vo : list){
            map.put("wardId",vo.getWardId());
            pageInfo.setCondition(map);
            vo.setFinalSettlementAmount(omsMapper.selectFinalSettlementAmount(pageInfo));
            vo.setThisPeriodSettlementAmount(omsMapper.selectThisPeriodSettlementAmount(pageInfo));
            vo.setThisPeriodAmount(omsMapper.selectThisPeriodAmount(pageInfo));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(omsMapper.findIncomeCount(pageInfo));
    }

    protected String getCafeteriaName(Integer id){
        HisCafeteria cafeteria = hisCafeteriaMapper.selectByPrimaryKey(id);
        if (null == cafeteria)
            return "";
        return cafeteria.getCafeteriaName();
    }

	@Override
	public void deleteByPrimaryKey(Integer id) {
		omsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public HisOms getHisOmsBy(String patientId, Date diningTime) {
		return omsMapper.getHisOmsBy(patientId, diningTime);
	}
}
