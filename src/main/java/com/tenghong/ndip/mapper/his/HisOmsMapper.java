package com.tenghong.ndip.mapper.his;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.vo.OrderInformationVo;
import com.tenghong.ndip.model.vo.OvenIndexVo;
import com.tenghong.ndip.model.vo.report.DeptWardVo;
import com.tenghong.ndip.model.vo.report.WardIncomeVo;
import com.tenghong.ndip.utils.PageInfo;

public interface HisOmsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisOms record);

    int insertSelective(HisOms record);

    HisOms selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisOms record);

    int updateByPrimaryKey(HisOms record);

    List<HisOms> findDataByIdList(@Param("list") List<Integer> list,@Param("userId") Integer userId);

    List<HisOms> findDataByIdMealId(Integer mealId);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisOms> findPageCondition(PageInfo pageInfo);

    int getOmsNum(@Param("patientId") String patientId,@Param("diningDate") String diningDate);

    //查询订单id
    List<Integer> getOmsIds(@Param("patientId") String patientId);

    //查询某日某餐次下成交的订单数量
    BigDecimal findOmsRewardNum(@Param("omsDate") Date date,@Param("mealId") Integer mealId,@Param("cafeteriaId") Integer cafeteriaId);

    //查询当日某灶类下成交的订单数量订单金额
    OvenIndexVo findDailyOrderVal(@Param("ovenId") Integer ovenId, @Param("cafeteriaId") Integer cafeteriaId);

    //查询病区金额分页
    List<WardIncomeVo> findIncome(PageInfo pageInfo);

    int findIncomeCount(PageInfo pageInfo);

    //查询上期结算金额

    Double selectFinalSettlementAmount(PageInfo pageInfo);

    //查询本期结算金额
    Double selectThisPeriodSettlementAmount(PageInfo pageInfo);

    //查询本期变动金额
    Double selectThisPeriodAmount(PageInfo pageInfo);

    //查询营业状况表病区
    List<DeptWardVo> findBuinessWard(PageInfo pageInfo);

    int findBuinessWardCount(PageInfo pageInfo);

    //查询餐次下结算金额
    Double selectMealTimesAmount(@Param("wardId") Integer wardId,@Param("mealId") Integer mealId,@Param("startDate") String startDate,@Param("endDate") String endDate);

    //查询灶类下结算金额
    Double selectOvenAmount(@Param("wardId") Integer wardId,@Param("ovenId") Integer ovenId,@Param("startDate") String startDate,@Param("endDate") String endDate);

    // 根据病人ID和订单日期查询订单
    HisOms getHisOmsBy(@Param("patientId")String patientId, @Param("diningDate")Date diningTime);

}