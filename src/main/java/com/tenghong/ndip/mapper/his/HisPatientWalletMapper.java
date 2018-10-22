package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisPatientWallet;

public interface HisPatientWalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisPatientWallet record);

    int insertSelective(HisPatientWallet record);

    HisPatientWallet selectByPrimaryKey(Integer id);

    HisPatientWallet selectByPatientId(String id);

    int updateByPrimaryKeySelective(HisPatientWallet record);

    int updateByPrimaryKey(HisPatientWallet record);
}