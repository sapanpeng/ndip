package com.tenghong.ndip.service.his;

import java.text.ParseException;
import java.util.List;

import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.model.vo.DailyPercentVo;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 20:19 2018/6/22
 */
public interface PatientService {

    //获取列表
    void getDataGrip(PageInfo pageInfo,String diningDate);

    //获取列表app
    List<HisPatient> getDataGrip(List<Integer> list,Integer userId);

    //获取病人实例
    HisPatient select(String patientId);

    //扣钱
    void dedWallet(HisOms oms);

    void rewardWallet(HisOms oms, Double price);

    //查询昨日病人住院数
    Integer getYesterdayPatients(Integer cafeteriaId);

    //查询昨日病人订餐人数
    Integer getYesterdayPatientsHadOrder(Integer cafeteriaId);

    //所有病人数
    Integer getPatientsNum();

    //查询病人两周内各餐次订餐数
    List<DailyPercentVo> getPatientOrderNum(Integer cafeteriaId) throws ParseException;

}
