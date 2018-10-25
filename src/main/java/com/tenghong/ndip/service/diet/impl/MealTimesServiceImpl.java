package com.tenghong.ndip.service.diet.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.diet.DietMealTimesMapper;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.model.diet.DietOvenType;
import com.tenghong.ndip.service.diet.MealTimesService;
import com.tenghong.ndip.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:06 2018/6/11
 */
@Service
public class MealTimesServiceImpl implements MealTimesService {

    @Autowired
    private DietMealTimesMapper mealTimesMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo, String path) {
        List<DietMealTimes> list = mealTimesMapper.findPageCondition(pageInfo);
        for (DietMealTimes times : list){
            times.setMealTimeIconVo(NdipUtils.ndipInstance().getImageUrl(times.getMealTimeIcon(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(mealTimesMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(DietMealTimes times) {
        mealTimesMapper.insertSelective(times);
    }

    @Override
    public DietMealTimes getInfo(Integer id, String path) {
        DietMealTimes times = mealTimesMapper.selectByPrimaryKey(id);
        times.setMealTimeIconVo(NdipUtils.ndipInstance().getImageUrl(times.getMealTimeIcon(),path));
        return times;
    }

    @Override
    public DietMealTimes select(Integer id) {
        return mealTimesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(DietMealTimes times) {
        mealTimesMapper.updateByPrimaryKeySelective(times);
    }

    @Override
    public List<DietMealTimes> getDataGrip(List<Integer> list, String path) {
        List<DietMealTimes> retList = mealTimesMapper.findDataByIdList(list);
        for (DietMealTimes times : retList){
            times.setMealTimeIconVo(NdipUtils.ndipInstance().getImageUrl(times.getMealTimeIcon(),path));
        }
        return retList;
    }

    @Override
    public List<DietMealTimes> getReportDataGrip(Integer cafeteriaId) {
        return  mealTimesMapper.findDataByCafeteriaId(cafeteriaId);
    }
}
