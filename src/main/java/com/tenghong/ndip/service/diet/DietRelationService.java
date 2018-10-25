package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietRelation;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:37 2018/6/18
 */
public interface DietRelationService {

    //获得列表
    List<DietRelation> getDataGrip(Integer parentId, Integer parentType);

    //保存实例
    void save(DietRelation relation);

    //更新实例
    void update(DietRelation relation);

    //查询实例
    DietRelation getInfo(Integer id);

    //删除实例
    void delete(Integer reParentId,Integer reParentType);

    //删除
    void delete(Integer id);

    //根据id,type查询菜单
    Integer getMenuId(Integer id,Integer type);
}
