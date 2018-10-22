package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisPatientOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HisPatientOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPatientOrders record);

    int insertSelective(HisPatientOrders record);

    HisPatientOrders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPatientOrders record);

    int updateByPrimaryKey(HisPatientOrders record);

    List<HisPatientOrders> findDataByIdList(@Param("list") List<Integer> list,@Param("userId") Integer userId);
}