package com.tenghong.ndip.mapper.his;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.his.HisOmsDetails;

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

	int updateBy(@Param("omsId")Integer omsId, @Param("userId")Integer userId, @Param("time")Date time);
	
	//根据订单ID查询订单详情
	List<HisOmsDetails> findOmsDetail(com.tenghong.ndip.utils.PageInfo pageInfo);

	//根据订单ID查询订单详情数量
	int findOmsDetailCount(com.tenghong.ndip.utils.PageInfo pageInfo);
}