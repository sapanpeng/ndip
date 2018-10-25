package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietElement;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:43 2018/6/15
 */
public interface ElementService {

    //保存营养素实例
    void save(DietElement element);

    //更新营养素实例
    void update(DietElement element);

    //查询营养素实例
    DietElement getInfo(Integer goalId,Integer goalType);
}
