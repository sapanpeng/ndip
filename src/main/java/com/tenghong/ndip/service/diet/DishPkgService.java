package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietDishPkg;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:44 2018/6/19
 */
public interface DishPkgService {

    //查询套餐库
    void getDataGrip(PageInfo pageInfo, String path);

    //保存套餐实例
    void save(DietDishPkg dish);

    //查询套餐详情
    DietDishPkg getInfo(Integer id, String path);

    //查询套餐实例
    DietDishPkg selectOne(Integer id);

    //更新套餐实例
    void update(DietDishPkg dish);

}
