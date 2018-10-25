package com.tenghong.ndip.service.his.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenghong.ndip.config.exception.NullException;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.core.constants.HisOmsEnum;
import com.tenghong.ndip.mapper.diet.DietMealTimesMapper;
import com.tenghong.ndip.mapper.diet.DietMenuMapper;
import com.tenghong.ndip.mapper.diet.DietOvenMapper;
import com.tenghong.ndip.mapper.diet.DietRelationMapper;
import com.tenghong.ndip.mapper.his.HisCafeteriaMapper;
import com.tenghong.ndip.mapper.his.HisInpatientAreaMapper;
import com.tenghong.ndip.mapper.his.HisOmsDetailsMapper;
import com.tenghong.ndip.mapper.his.HisOmsMapper;
import com.tenghong.ndip.mapper.his.HisOmsStatusMapper;
import com.tenghong.ndip.mapper.his.HisPatientMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletMapper;
import com.tenghong.ndip.mapper.his.HisPatientWalletRecordsMapper;
import com.tenghong.ndip.mapper.sys.SysUserMapper;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.dto.OmsAppDto;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.model.his.HisOmsStatus;
import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.model.his.HisPatientWallet;
import com.tenghong.ndip.model.his.HisPatientWalletRecords;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.his.DataSaveSerice;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:40 2018/7/13
 */
@Service
public class DataSaveSerivceImpl implements DataSaveSerice {

    @Autowired
    private DietMealTimesMapper dietMealTimesMapper;

    @Autowired
    private HisCafeteriaMapper hisCafeteriaMapper;

    @Autowired
    private HisOmsMapper omsMapper;

    @Autowired
    private HisOmsStatusMapper omsStatusMapper;

    @Autowired
    private HisOmsDetailsMapper omsDetailsMapper;

    @Autowired
    private DietRelationMapper dietRelationMapper;

    @Autowired
    private DietOvenMapper ovenMapper;

    @Autowired
    private DietMenuMapper menuMapper;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private HisPatientMapper patientMapper;

    @Autowired
    private HisPatientWalletMapper patientWalletMapper;

    @Autowired
    private HisInpatientAreaMapper inpatientAreaMapper;

    @Autowired
    private HisPatientWalletRecordsMapper patientWalletRecordsMapper;

    @Override
    @Transactional
    public Result saveAppData(List<OmsAppDto> dtoList, String style) {
        Result result = new Result();
        for (OmsAppDto dto : dtoList) {
            if (!dataHasChanged(dto))
                continue;
            Double price = 0.00;
            for (HisOmsDetails detail : dto.getDetailDto()) {
                detail.setCurrentPrice(getDouble(detail.getGoalPrice() * detail.getGoalNum()));
                price += detail.getCurrentPrice();
            }
            DietMealTimes times = dietMealTimesMapper.selectByPrimaryKey(dto.getMealId());
            HisCafeteria cafeteria = hisCafeteriaMapper.selectByPrimaryKey(times.getCafeteriaId());
            //如果订单是历史订单
            if (dto.getOmsId() != null && !dto.getOmsId().toString().equals("0")) {
                HisOms oms = omsMapper.selectByPrimaryKey(dto.getOmsId());
                if (oms.getOmsType() == HisOmsEnum.PAY.getType()) {
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

                    //刷新订单
                    oms.setOmsType(HisOmsEnum.PAY.getType());
                    omsMapper.updateByPrimaryKeySelective(oms);

                    //记录订单状态
                    HisOmsStatus status = new HisOmsStatus();
                    status.setStatus(HisOmsEnum.PAY.getType());
                    status.setOrderId(oms.getId());
                    status.setCreateTime(new Date());
                    omsStatusMapper.insertSelective(status);
                }
                oms.setOmsType(HisOmsEnum.REFUND.getType());
                oms.setUpdateTime(new Date());
                oms.setUpdateBy(getCurrentUser(dto.getToken()).getUserId());
                //完成退单
                omsMapper.updateByPrimaryKeySelective(oms);
                saveOmsStatus(oms.getId(), oms.getOmsType(), oms.getCreateBy(), oms.getCreateTime());
            }
            //新下单
            HisOms omsNew = new HisOms();
            HisPatient patientS = patientMapper.selectByPatientId(dto.getPatientId());
            HisInpatientArea area = inpatientAreaMapper.selectByCode(patientS.getWardCode());
            if (null == area) {
                throw new NullException();
            }
            omsNew.setPatientId(dto.getPatientId());
            omsNew.setWardId(area.getId());
            omsNew.setWardName(area.getWardName());
            omsNew.setMealId(dto.getMealId());
            omsNew.setMealName(dto.getMealName());
            omsNew.setCafeteriaId(cafeteria.getId());
            omsNew.setCafeteriaName(cafeteria.getCafeteriaName());
            omsNew.setCreateTime(new Date());
            omsNew.setCreateBy(getCurrentUser(dto.getToken()).getUserId());
            omsNew.setOmsType(HisOmsEnum.WAIT_FOR_PAY.getType());
            omsNew.setUserName(getCurrentUser(dto.getToken()).getUserName());
            omsNew.setUserId(getCurrentUser(dto.getToken()).getUserId());
            omsNew.setDiningTime(dto.getDiningTime());
            omsNew.setPrice(getDouble(price));
            omsMapper.insertSelective(omsNew);
            saveOmsStatus(omsNew.getId(), omsNew.getOmsType(), omsNew.getCreateBy(), omsNew.getCreateTime());
            for (HisOmsDetails detail : dto.getDetailDto()) {
                Integer menuId = dietRelationMapper.getMenuId(detail.getGoalId(), detail.getGoalType());
                DietOven oven = ovenMapper.selectByPrimaryKey(menuMapper.selectByPrimaryKey(menuId).getOvenId());
                detail.setOmsId(omsNew.getId());
                detail.setMealId(omsNew.getMealId());
                detail.setMealName(omsNew.getMealName());
                detail.setOvenId(oven.getId());
                detail.setOvenName(oven.getOvenName());
                omsDetailsMapper.insertSelective(detail);
            }

            //实时扣款
            if (style.equals("1")) {
                HisPatientWallet wallet = patientWalletMapper.selectByPatientId(omsNew.getPatientId());
                wallet.setTotalWallet(wallet.getTotalWallet() - omsNew.getPrice());
                patientWalletMapper.updateByPrimaryKey(wallet);

                //记录病人钱包变动
                HisPatientWalletRecords records = new HisPatientWalletRecords();
                records.setFlag(0);
                records.setCurrentAmount(omsNew.getPrice());
                records.setPatientId(omsNew.getPatientId());
                records.setMemo("系统订餐扣减");
                records.setCreateTime(new Date());
                patientWalletRecordsMapper.insertSelective(records);

                //刷新订单
                omsNew.setOmsType(HisOmsEnum.PAY.getType());
                omsMapper.updateByPrimaryKeySelective(omsNew);

                //记录订单状态
                HisOmsStatus status = new HisOmsStatus();
                status.setOrderId(omsNew.getId());
                status.setStatus(HisOmsEnum.PAY.getType());
                status.setCreateTime(new Date());
                omsStatusMapper.insertSelective(status);
            }
        }
        result.setMsg("success");
        result.setState(1);
        return result;
    }

    @Override
    @Transactional
    public Result saveWebData(List<HisOmsDetails> details, Date diningTime, List<String> list, String token, String style) {
        Result result = new Result();
        List<HisOms> omsList = new ArrayList<HisOms>();
        for (String item : list) {
        	HisOms oms = null;
            for (HisOmsDetails detail : details) {
            	for (HisOms hisOms : omsList) {
            		if (hisOms.getMealId() == detail.getMealId() && hisOms.getPatientId().equals(item)) {
            			oms = hisOms;
            		} 
            	}
            	
            	if (oms == null) {
        			oms = new HisOms();
        			omsList.add(oms);
        		}
            	
            	 Double price = oms.getPrice();
            	 if (price == null) {
            		 price = Double.valueOf(0);
            	 }
            	 detail.setCurrentPrice(getDouble(detail.getGoalPrice() * detail.getGoalNum()));
                 price += detail.getCurrentPrice();
            	
            	HisPatient patientS = patientMapper.selectByPatientId(item);
                HisInpatientArea area = inpatientAreaMapper.selectByCode(patientS.getWardCode());
                if (null == area) {
                    throw new NullException();
                }
                oms.setPatientId(item);
                oms.setWardId(area.getId());
                oms.setWardName(area.getWardName());
                oms.setMealId(detail.getMealId());
                oms.setMealName(detail.getMealName());
                oms.setCreateTime(new Date());
                oms.setCreateBy(getCurrentUser(token).getUserId());
                oms.setOmsType(HisOmsEnum.WAIT_FOR_PAY.getType());
                oms.setUserName(getCurrentUser(token).getUserName());
                oms.setUserId(getCurrentUser(token).getUserId());
                oms.setDiningTime(diningTime);
                oms.setPrice(price);
                oms.getHisOmsDetails().add(detail);
//                omsMapper.insertSelective(oms);
//                saveOmsStatus(oms.getId(), oms.getOmsType(), oms.getCreateBy(), oms.getCreateTime());
//                detail.setOmsId(oms.getId());
//                detail.setMealId(oms.getMealId());
//                detail.setMealName(oms.getMealName());
//                omsDetailsMapper.insertSelective(detail);
            }
        }
        
        for (HisOms hisOms : omsList) {
            HisPatient patientS = patientMapper.selectByPatientId(hisOms.getPatientId());
            HisInpatientArea area = inpatientAreaMapper.selectByCode(patientS.getWardCode());
            
            DietMealTimes times = dietMealTimesMapper.selectByPrimaryKey(hisOms.getMealId());
            HisCafeteria cafeteria = hisCafeteriaMapper.selectByPrimaryKey(times.getCafeteriaId());
            hisOms.setCafeteriaId(cafeteria.getId());
            hisOms.setCafeteriaName(cafeteria.getCafeteriaName());
            
            if (null == area) {
                throw new NullException();
            }
            hisOms.setWardId(area.getId());
            hisOms.setWardName(area.getWardName());
            hisOms.setCafeteriaId(cafeteria.getId());
            hisOms.setCafeteriaName(cafeteria.getCafeteriaName());
            omsMapper.insertSelective(hisOms);
            saveOmsStatus(hisOms.getId(), hisOms.getOmsType(), hisOms.getCreateBy(), hisOms.getCreateTime());
            for (HisOmsDetails hisOmsDetails : hisOms.getHisOmsDetails()) {
           	 hisOmsDetails.setOmsId(hisOms.getId());
           	 omsDetailsMapper.insertSelective(hisOmsDetails);
            }
            
            //实时扣款
            if (style.equals("1")) {
                HisPatientWallet wallet = patientWalletMapper.selectByPatientId(hisOms.getPatientId());
                wallet.setTotalWallet(wallet.getTotalWallet() - hisOms.getPrice());
                patientWalletMapper.updateByPrimaryKey(wallet);

                //记录病人钱包变动
                HisPatientWalletRecords records = new HisPatientWalletRecords();
                records.setFlag(0);
                records.setCurrentAmount(hisOms.getPrice());
                records.setPatientId(hisOms.getPatientId());
                records.setMemo("系统订餐扣减");
                records.setCreateTime(new Date());
                patientWalletRecordsMapper.insertSelective(records);

                //刷新订单
                hisOms.setOmsType(HisOmsEnum.PAY.getType());
                omsMapper.updateByPrimaryKeySelective(hisOms);

                //记录订单状态
                HisOmsStatus status = new HisOmsStatus();
                status.setOrderId(hisOms.getId());
                status.setStatus(HisOmsEnum.PAY.getType());
                status.setCreateTime(new Date());
                omsStatusMapper.insertSelective(status);
            }
       }
        result.setState(1);
        result.setMsg("success");
        return result;
    }


    public Double getDouble(Double f) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(f));
    }

    private SysUser getCurrentUser(String token) {
        return userMapper.selectByToken(token);
    }

    private void saveOmsStatus(Integer omsId, Integer status, Integer userId, Date time) {
        HisOmsStatus omsStatus = new HisOmsStatus();
        omsStatus.setOrderId(omsId);
        omsStatus.setStatus(status);
        omsStatus.setCreateBy(userId);
        omsStatus.setCreateTime(time);
        omsStatusMapper.insertSelective(omsStatus);
    }

    //判断数据是否发生变化
    private Boolean dataHasChanged(OmsAppDto dto) {
        List<HisOmsDetails> detailsForDb = omsDetailsMapper.selectByOmsId(dto.getOmsId());
        List<HisOmsDetails> detailsForApp = dto.getDetailDto();
        if (detailsForDb.size() != detailsForApp.size())
            return true;
        for (HisOmsDetails detailsApp : detailsForApp) {
            for (HisOmsDetails detailsDb : detailsForDb) {
                if (detailsApp.getId() == detailsDb.getId()) {
                    if (detailsApp.getGoalNum() != detailsDb.getGoalNum())
                        return true;
                }
            }
        }
        return false;
    }
}
