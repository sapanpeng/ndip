package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:15 2018/6/10
 */
public interface MealTimesService {

    void getDataGrip(PageInfo pageInfo,String path);

    //保存餐次实例
    void save(DietMealTimes times);

    //查询详情
    DietMealTimes getInfo(Integer id,String path);

    //查询餐次实例
    DietMealTimes select(Integer id);

    //更新餐次实例(逻辑删除)
    void update(DietMealTimes times);

    List<DietMealTimes> getDataGrip(List<Integer> list, String path);

    List<DietMealTimes> getReportDataGrip(Integer cafeteriaId);

}
