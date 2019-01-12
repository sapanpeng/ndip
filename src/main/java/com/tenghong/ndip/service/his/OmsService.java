package com.tenghong.ndip.service.his;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.command.OrderReportCommand;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.vo.DeliverOrderVO;
import com.tenghong.ndip.model.vo.ReceiveOrderVO;
import com.tenghong.ndip.model.vo.report.DeptIncomeVo;
import com.tenghong.ndip.model.vo.report.OvenDetailsVo;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:26 2018/6/23
 */
public interface OmsService {

    //保存订单实例
    void save(HisOms oms);
    
    //查询订单app
    List<HisOms> getDataGrip(List<Integer> list,Integer userId);

    //刷新订单相关业务操作
    void refreshOms(Integer mealTimesId);

    //查询领餐表数据
    ReceiveOrderVO selectReceiveDetail(OrderReportCommand bo);

    //查询送餐表数据
    DeliverOrderVO selectDeliverDetail(OrderReportCommand bo);

    //查询订单数据
    void getData(PageInfo pageInfo);

    HisOms getOne(Integer id);

    void update(HisOms oms);

    //查询昨日营业额
    Double getYesterdayReward(Integer cafeteriaId);

    //查询所有病区金额
    void getWardIncome(PageInfo pageInfo);

    //科室营业情况表
    DeptIncomeVo getDeptIncome(PageInfo pageInfo );

    //灶类明细统计
    List<OvenDetailsVo> getOvenRecords(Integer cafeteriaId, Integer ovenId, String date, String departmentId, Integer mealTimesId);

    //根据ID删除订单 
	void deleteByPrimaryKey(Integer id);
	
	 // 根据病人ID和订单日期查询订单
    HisOms getHisOmsBy(String patientId, Date diningTime);

    //原材料统计

}
