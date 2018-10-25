package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietDish;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:51 2018/6/13
 */
public interface DishService {

    //查询菜谱库
    void getDataGrip(PageInfo pageInfo,String path);

    //保存菜谱实例
    void save(DietDish dish);

    //查询菜谱详情
    DietDish getInfo(Integer id,String path);

    //查询菜单实例
    DietDish selectOne(Integer id);

    void update(DietDish dietDish);
}
