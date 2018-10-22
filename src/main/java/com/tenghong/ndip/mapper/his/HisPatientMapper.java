package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HisPatientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPatient record);

    int insertSelective(HisPatient record);

    HisPatient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPatient record);

    int updateByPrimaryKey(HisPatient record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisPatient> findPageCondition(PageInfo pageInfo);

    List<HisPatient> findDataByIdList(@Param("list") List<Integer> list,@Param("userId") Integer userId);

    //获取病人实例
    HisPatient selectByPatientId(String patientId);

    //查询灶类id
    Integer selectOvenId(@Param("patientId") String patientId);
}