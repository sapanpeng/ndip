package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.his.HisMealTypeMapper;
import com.tenghong.ndip.model.his.HisMealType;
import com.tenghong.ndip.service.his.MealService;
import com.tenghong.ndip.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:25 2018/6/10
 */
@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private HisMealTypeMapper mealTypeMapper;

    @Override
    public void getTypeDataGrip(PageInfo pageInfo, String path) {
        List<HisMealType> list = mealTypeMapper.findPageCondition(pageInfo);
        for (HisMealType type : list){
            type.setMealTypePicVo(NdipUtils.ndipInstance().getImageUrl(type.getMealTypePic(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(mealTypeMapper.findPageCount(pageInfo));
    }

    @Override
    public void saveType(HisMealType type) {
        mealTypeMapper.insertSelective(type);
    }

    @Override
    public HisMealType getTypeInfo(Integer id) {
        return mealTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editType(HisMealType type) {
        mealTypeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public HisMealType select(Integer id, String path) {
        HisMealType type = mealTypeMapper.selectByPrimaryKey(id);
        type.setMealTypePicVo(NdipUtils.ndipInstance().getImageUrl(type.getMealTypePic(),path));
        return type;
    }
}
