package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.his.HisMealType;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:25 2018/6/10
 */
public interface MealService {
    //查询菜谱类别列表
    void getTypeDataGrip(PageInfo pageInfo,String token);

    //保存菜谱列表实例
    void saveType(HisMealType type);

    //获取菜谱列表实例
    HisMealType getTypeInfo(Integer id);

    //修改菜谱列表实例(逻辑删除)
    void editType(HisMealType type);

    HisMealType select(Integer id,String path);
}
