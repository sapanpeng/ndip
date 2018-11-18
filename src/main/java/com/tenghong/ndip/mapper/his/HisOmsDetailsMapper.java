package com.tenghong.ndip.mapper.his;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.model.vo.report.OvenCountVo;

public interface HisOmsDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisOmsDetails record);

    int insertSelective(HisOmsDetails record);

    HisOmsDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisOmsDetails record);

    int updateByPrimaryKey(HisOmsDetails record);

    //查询列表
    List<HisOmsDetails> getList(@Param("flag") Integer flag,@Param("patientId") String patientId,@Param("diningDate") String date,@Param("mealId") Integer mealId);

    //查询详情
    List<HisOmsDetails> getDetailsList(@Param("list") List<Integer> list);

    //根据订单id查询订单详情
    List<HisOmsDetails> selectByOmsId(@Param("omsId") Integer omsId);

    //查询某日某个餐次下订单明细
    List<OvenCountVo> selectOmsDetailsForReport(@Param("date") String date,@Param("ovenId") Integer ovenId,@Param("mealId") Integer mealId);

    //统计菜的数量
    Integer getGoalNum(@Param("wardId") Integer wardId,@Param("ovenId") Integer ovenId,@Param("date") String date);

	int updateBy(@Param("omsId")Integer omsId, Integer userId, Date time);
}