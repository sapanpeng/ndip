package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.his.HisRelation;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:45 2018/6/8
 */
public interface AreaCafeteriaService {

    //关联
    void save(HisRelation relation);

    //列表查询
    void getDataGrip(PageInfo pageInfo);

    //查询实例
    HisRelation getInfo(Integer id);

    //更新实例(逻辑删除)
    void update(HisRelation relation);

    //查询所有关联
    List<HisRelation> gelAll(Integer userId);

    //查询所有食堂id
    List<Integer> getCatefeteriaIds(String userName);

    //查询所有病区
    List<Integer> getWardIds(Integer userId);
}
