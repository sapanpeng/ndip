package com.tenghong.ndip.service.his.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenghong.ndip.core.constants.HisOmsEnum;
import com.tenghong.ndip.mapper.his.HisOmsDetailsMapper;
import com.tenghong.ndip.mapper.his.HisOmsMapper;
import com.tenghong.ndip.mapper.his.HisOmsStatusMapper;
import com.tenghong.ndip.mapper.his.HisPatientMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletRecordsMapper;
import com.tenghong.ndip.model.dto.MealTimesDto;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisOmsStatus;
import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.model.his.HisPatientWallet;
import com.tenghong.ndip.model.his.HisPatientWalletRecords;
import com.tenghong.ndip.model.vo.DailyPercentVo;
import com.tenghong.ndip.service.his.PatientService;
import com.tenghong.ndip.utils.DateUtil;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 20:19 2018/6/22
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private HisPatientMapper patientMapper;

    @Autowired
    private HisOmsMapper omsMapper;

    @Autowired
    private HisPatientWalletMapper patientWalletMapper;

    @Autowired
    private HisPatientWalletRecordsMapper patientWalletRecordsMapper;

    @Autowired
    private HisOmsStatusMapper omsStatusMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Autowired
    private HisOmsDetailsMapper hisOmsDetailsMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo,String diningDate) {
        List<HisPatient> patients = patientMapper.findPageCondition(pageInfo);
        for (HisPatient item : patients){
            Integer num = omsMapper.getOmsNum(item.getPatientId(),diningDate);
            item.setOvenId(patientMapper.selectOvenId(item.getPatientId()));
            if (num > 0){
                item.setFlag(1);
                item.setDiningDate(DateUtil.parseDate(diningDate));
            }else {
                item.setFlag(0);
            }
        }
        pageInfo.setRows(patients);
        pageInfo.setRecords(patientMapper.findPageCount(pageInfo));
    }

    @Override
    public List<HisPatient> getDataGrip(List<Integer> list,Integer userId) {
        List<HisPatient> retList = patientMapper.findDataByIdList(list,userId);
        String sql = "select cafeteria_id as cafeteriaId from his_relation where ward_code = #{wardCode}";
        for (HisPatient patient : retList){
            patient.setCafeteriaList(sqlMapper.selectList(sql,patient.getWardCode(),int.class));
            List<Integer> omsList = omsMapper.getOmsIds(patient.getPatientId());
            if (omsList.size()>0)
                patient.setDetailsList(hisOmsDetailsMapper.getDetailsList(omsList));
            if (DateUtil.format(patient.getInHosDate(),"yyyy-MM-dd").equals(DateUtil.format(new Date(),"yyyy-MM-dd")))
                patient.setNewPatient(1);
            else
                patient.setNewPatient(0);
        }
        return retList;
    }

    @Override
    public HisPatient select(String patientId) {
        return patientMapper.selectByPatientId(patientId);
    }

    @Override
    @Transactional
    public void dedWallet(HisOms oms) {
        HisPatientWallet wallet = patientWalletMapper.selectByPatientId(oms.getPatientId());
        wallet.setTotalWallet(wallet.getTotalWallet() - oms.getPrice());
        patientWalletMapper.updateByPrimaryKey(wallet);

        //记录病人钱包变动
        HisPatientWalletRecords records = new HisPatientWalletRecords();
        records.setFlag(0);
        records.setPatientId(oms.getPatientId());
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

    @Override
    @Transactional
    public void rewardWallet(HisOms oms) {
        HisPatientWallet wallet = patientWalletMapper.selectByPatientId(oms.getPatientId());
        wallet.setTotalWallet(wallet.getTotalWallet() + oms.getPrice());
        patientWalletMapper.updateByPrimaryKey(wallet);

        //记录病人钱包变动
        HisPatientWalletRecords records = new HisPatientWalletRecords();
        records.setFlag(0);
        records.setPatientId(oms.getPatientId());
        records.setCurrentAmount(oms.getPrice());
        records.setMemo("系统退餐退款");
        records.setCreateTime(new Date());
        patientWalletRecordsMapper.insertSelective(records);

//        //刷新订单
//        oms.setOmsType(HisOmsEnum.PAY.getType());
//        omsMapper.updateByPrimaryKeySelective(oms);
//
//        //记录订单状态
//        HisOmsStatus status = new HisOmsStatus();
//        status.setOrderId(oms.getId());
//        status.setStatus(HisOmsEnum.PAY.getType());
//        status.setCreateTime(new Date());
//        omsStatusMapper.insertSelective(status);
    }

    @Override
    public Integer getYesterdayPatients() {
        String sql = "select count(1) from his_patient where DATE_FORMAT(in_hos_date,'%Y-%m-%d') = DATE_SUB(curdate(),INTERVAL +  1 DAY)";
        return sqlMapper.selectOne(sql,int.class);
    }

    @Override
    public Integer getYesterdayPatientsHadOrder() {
        String sql = "select count(1) from his_oms where DATE_FORMAT(dining_time,'%Y-%m-%d') = DATE_SUB(curdate(),INTERVAL +  1 DAY)";
        return sqlMapper.selectOne(sql,int.class);
    }

    @Override
    public Integer getPatientsNum() {
        String sql = "select count(1) from his_patient where out_status = 0";
        return sqlMapper.selectOne(sql,int.class);
    }

    @Override
    public List<DailyPercentVo> getPatientOrderNum(Integer cafeteriaId) throws ParseException {
        //查询系统内所有餐次
        String sql = "select id,meal_time_name as `name` from diet_meal_times where cafeteria_id = #{cafeteriaId} and status = 1";
        List<MealTimesDto> mealList = sqlMapper.selectList(sql,cafeteriaId,MealTimesDto.class);
        List<DailyPercentVo> list = new ArrayList<>();
        for (int i = 0;i < 14; i++){
            List<BigDecimal> valueList = new ArrayList<>();
            List<String> stringList = new ArrayList<>();
            DailyPercentVo vo = new DailyPercentVo();
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate1 = dateFormat1.parse("2018-09-17");
            vo.setDate(DateUtil.getOtherDay(myDate1,-i));
            for (MealTimesDto dto : mealList){
                stringList.add(dto.getName());
                valueList.add(omsMapper.findOmsRewardNum(vo.getDate(),dto.getId(),cafeteriaId));
            }
            vo.setLabel(stringList);
            vo.setValue(valueList);
            list.add(vo);
        }
        return list;
    }
}
