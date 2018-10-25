package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.mapper.his.HisOrderOvenRelationMapper;
import com.tenghong.ndip.model.his.HisOrderOvenRelation;
import com.tenghong.ndip.model.vo.OrderVo;
import com.tenghong.ndip.service.diet.OvenService;
import com.tenghong.ndip.service.his.OvenOrderService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:34 2018/6/20
 */
@Service
public class OvenOrderServiceImpl implements OvenOrderService{

    @Autowired
    private HisOrderOvenRelationMapper orderOvenRelationMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo) {
        pageInfo.setRows(orderOvenRelationMapper.findPageCondition(pageInfo));
        pageInfo.setRecords(orderOvenRelationMapper.findPageCount(pageInfo));
    }

    @Override
    public List<HisOrderOvenRelation> list() {
        String sql = "select order_code as orderCode,oven_id as ovenId,oven_type_id ovenTypeId from his_order_oven_relation";
        return sqlMapper.selectList(sql,HisOrderOvenRelation.class);
    }

    @Override
    public void update(HisOrderOvenRelation relation) {
        orderOvenRelationMapper.updateByPrimaryKeySelective(relation);
    }

    @Override
    public HisOrderOvenRelation select(Integer id) {
        return orderOvenRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(HisOrderOvenRelation relation) {
        orderOvenRelationMapper.insertSelective(relation);
    }

    @Override
    public List<OrderVo> getOrderList() {
        String sql = "select order_code as orderCode,order_name "+
                "as orderName,order_class_code as orderClassCode," +
                "order_class_name as orderClassName from his_order";
        List<OrderVo> list = sqlMapper.selectList(sql,OrderVo.class);
        return list;
    }

    @Override
    public void delete(Integer id) {
        orderOvenRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean selectByOrderCode(String orderCode) {
        String sql = "select count(1) from his_order_oven_relation where order_code = #{orderCode}";
        Integer num = sqlMapper.selectOne(sql,orderCode,int.class);
        if (num != null && num.toString().equals("0"))
            return true;
        return false;
    }
}
