package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietMatl;
import com.tenghong.ndip.model.diet.DietMatlType;
import com.tenghong.ndip.model.diet.IntlFood;
import com.tenghong.ndip.model.diet.IntlFoodType;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:42 2018/6/12
 */
public interface MaterialService {

    //获取国标食物类型列表
    List<IntlFoodType> getIntlTypeDataGrip();

    //获取国标食物列表
    void getIntlDataGrip(Integer typeId, PageInfo pageInfo,Map<String,Object> map,Integer level, String name);

    //获取国标食物详情
    IntlFood getInfo(String id);

    //获取原材料类别列表
    List<DietMatlType> getMatlTypeDataGrip();

    //获取原材料列表
    void getDataGrip(PageInfo pageInfo);

    //保存原材料实例
    void save(DietMatl matl);

    //查询原材料实例
    DietMatl select(Integer id);

    //修改原材料实例(逻辑删除)
    void update(DietMatl matl);

    //查询原材料库实例
    DietMatl getInfo(Integer id);
}
