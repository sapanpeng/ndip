package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.his.HisOrderOvenRelation;
import com.tenghong.ndip.model.vo.OrderVo;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:34 2018/6/20
 */
public interface OvenOrderService {

    //获取关系列表
    void getDataGrip(PageInfo pageInfo);

    //查询所有
    List<HisOrderOvenRelation> list();

    //修改关系实例
    void update(HisOrderOvenRelation relation);

    //查询关系实例
    HisOrderOvenRelation select(Integer id);

    //保存关系实例
    void save(HisOrderOvenRelation relation);

    //查询医嘱实例
    List<OrderVo> getOrderList();

    //删除实例
    void delete(Integer id);

    //查询灶类医嘱关系
    Boolean selectByOrderCode(String orderCode);

}
