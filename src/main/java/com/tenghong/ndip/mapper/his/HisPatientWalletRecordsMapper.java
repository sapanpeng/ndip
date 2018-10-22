package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisPatientWalletRecords;

public interface HisPatientWalletRecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPatientWalletRecords record);

    int insertSelective(HisPatientWalletRecords record);

    HisPatientWalletRecords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisPatientWalletRecords record);

    int updateByPrimaryKey(HisPatientWalletRecords record);
}