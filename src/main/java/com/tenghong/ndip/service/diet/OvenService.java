package com.tenghong.ndip.service.diet;

import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.diet.DietOvenType;
import com.tenghong.ndip.model.vo.OvenIndexVo;
import com.tenghong.ndip.model.vo.OvenTreeVo;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:04 2018/6/7
 */
public interface OvenService {
    //查询灶类类别列表
    void getTypeDataGrip(PageInfo pageInfo,String path);

    //保存灶类类别
    void saveType(DietOvenType type);

    //查询灶类类别实例
    DietOvenType getInfoType(Integer id,String path);

    //更新灶类类别实例
    void updateType(DietOvenType type);

    //查询灶类列表
    void getDataGrip(PageInfo pageInfo);

    //保存灶类实例
    void save(DietOven oven);

    //查询灶类实例
    DietOven getInfo(Integer id);

    //更新灶类实例(逻辑删除)
    void update(DietOven oven);

    //获得树
    List<OvenTreeVo> getTree(Integer id);

    //查询灶类类别列表
    List<DietOvenType> getTypeDataGrip(List<Integer> list,String path);

    List<DietOven> getDataGrip(List<Integer> list);

    //根据菜单id查询灶类实例
    DietOven getInfoByMenuId(Integer id);

    //查询当日订餐金额
    List<OvenIndexVo> getDailyOrderVal(Integer cafeteriaId);
}
