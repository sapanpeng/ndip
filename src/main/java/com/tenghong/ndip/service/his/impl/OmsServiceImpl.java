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
import com.tenghong.ndip.mapper.diet.DietMealTimesMapper;
import com.tenghong.ndip.mapper.diet.DietOvenMapper;
import com.tenghong.ndip.mapper.his.HisCafeteriaMapper;
import com.tenghong.ndip.mapper.his.HisInpatientAreaMapper;
import com.tenghong.ndip.mapper.his.HisOmsDetailsEntityMapper;
import com.tenghong.ndip.mapper.his.HisOmsDetailsMapper;
import com.tenghong.ndip.mapper.his.HisOmsEntityMapper;
import com.tenghong.ndip.mapper.his.HisOmsMapper;
import com.tenghong.ndip.mapper.his.HisOmsStatusMapper;
import com.tenghong.ndip.mapper.his.HisPatientMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletRecordsMapper;
import com.tenghong.ndip.model.bo.DeliverOrderBO;
import com.tenghong.ndip.model.bo.ReceiveOrderBO;
import com.tenghong.ndip.model.command.OrderReportCommand;
import com.tenghong.ndip.model.diet.DietMealTimes;
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
import com.tenghong.ndip.model.vo.OvenIndexVo;
import com.tenghong.ndip.model.vo.ReceiveOrderVO;
import com.tenghong.ndip.model.vo.report.DeptIncomeVo;
import com.tenghong.ndip.model.vo.report.DeptWardVo;
import com.tenghong.ndip.model.vo.report.OvenCountVo;
import com.tenghong.ndip.model.vo.report.OvenDetailsVo;
import com.tenghong.ndip.model.vo.report.WardDto;
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
    private HisOmsDetailsMapper omsDetailsMapper;

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

    @Autowired
    private HisInpatientAreaMapper hisInpatientAreaMapper;

    @Autowired
    private DietMealTimesMapper dietMealTimesMapper;

    @Autowired
    private DietOvenMapper ovenMapper;

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
    public Double getYesterdayReward() {
        String sql = "select sum(price) from his_oms where DATE_FORMAT(dining_time,'%Y-%m-%d') = DATE_SUB(curdate(),INTERVAL +  1 DAY) and oms_type = 2";
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

    @Override
    public DeptIncomeVo getDeptIncome(com.tenghong.ndip.utils.PageInfo pageInfo) {
        int flag = 0;
        List<String> titleList = new ArrayList<>();
        DeptIncomeVo retVo = new DeptIncomeVo();
        titleList.add("病区");
        titleList.add("总金额");
        List<DeptWardVo> list = omsMapper.findBuinessWard(pageInfo);
        List<DietMealTimes> mealTimesList = dietMealTimesMapper.findDataByCafeteriaId((int)pageInfo.getCondition().get("cafeteriaId"));
        List<OvenIndexVo> ovenList = ovenMapper.findOvenIndexVo((int)pageInfo.getCondition().get("cafeteriaId"));
        for (DeptWardVo vo : list){
            List<Double> doubelList = new ArrayList<>();
            Double sumDouble = 0.00;
            doubelList.add(sumDouble);
            for (int i = 0;i < mealTimesList.size(); i ++){
                Double mealTimesAmount = omsMapper.selectMealTimesAmount(vo.getWardId(),mealTimesList.get(i).getId(),pageInfo.getCondition().get("startDate").toString(),pageInfo.getCondition().get("endDate").toString());
                doubelList.add(doubelList.size(),mealTimesAmount);
                if (flag == 0)
                titleList.add(mealTimesList.get(i).getMealTimeName());
                sumDouble = sumDouble + mealTimesAmount;
            }
            for (int j = 0;j < ovenList.size(); j ++){
                Double ovenAmount = omsMapper.selectOvenAmount(vo.getWardId(),ovenList.get(j).getOvenId(),pageInfo.getCondition().get("startDate").toString(),pageInfo.getCondition().get("endDate").toString());
                doubelList.add(doubelList.size(),ovenAmount);
                if (flag == 0)
                titleList.add(ovenList.get(j).getOvenName());
                sumDouble = sumDouble + ovenAmount;
            }
            doubelList.set(0,sumDouble);
            vo.setList(doubelList);
            flag = 1;
        }
        retVo.setThList(titleList);
        retVo.setWardList(list);
        return retVo;
    }

    @Override
    public void getOrderInformation(com.tenghong.ndip.utils.PageInfo pageInfo) {
        pageInfo.setRows(omsMapper.selectOrderInformation(pageInfo));
        pageInfo.setTotal(omsMapper.selectOrderInformationCount(pageInfo));
    }

    @Override
    public List<OvenDetailsVo> getOvenRecords(Integer cafeteriaId,Integer ovenId,String date,String departmentId,Integer mealTimesId) {
        List<WardDto> wardList = hisInpatientAreaMapper.findWardDto(cafeteriaId);
        List<DietMealTimes> mealList = dietMealTimesMapper.findDataByReq(cafeteriaId,mealTimesId);
        List<OvenDetailsVo> retList = new ArrayList<>();
        List<String> thList = new ArrayList<>();
        for (DietMealTimes times : mealList){
            Integer flag = 0;
            OvenDetailsVo detailsVo = new OvenDetailsVo();
            detailsVo.setTitle(getCafeteriaName(cafeteriaId)+"灶类明细统计表");
            detailsVo.setDate(date);
            detailsVo.setMealTimeName(times.getMealTimeName());
            retList.add(detailsVo);
            List<String> list = new ArrayList<>();
            Integer sum = 0;
            List<OvenCountVo> innerList = omsDetailsMapper.selectOmsDetailsForReport(date,ovenId,times.getId());
            for (OvenCountVo vo : innerList){
                List<Integer> numList = new ArrayList<>();
                for (WardDto dto : wardList){
                    if (flag == 0)
                        list.add(dto.getWardName());
                    Integer num = omsDetailsMapper.getGoalNum(dto.getWardId(),vo.getOvenId(),date);
                    numList.add(num);
                    sum += num;
                }
                flag = 1;
                vo.setNumbers(numList);
                vo.setSum(sum);
            }
            detailsVo.setList(innerList);
            detailsVo.setWardNameList(list);
            thList = list;
        }
        for (OvenDetailsVo vo : retList){
            if (vo.getWardNameList().isEmpty() || null == vo.getWardNameList())
                vo.setWardNameList(thList);
        }
        return retList;
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
