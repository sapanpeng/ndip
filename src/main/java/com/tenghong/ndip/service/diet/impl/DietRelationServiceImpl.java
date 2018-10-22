package com.tenghong.ndip.service.diet.impl;

import com.tenghong.ndip.mapper.diet.DietRelationMapper;
import com.tenghong.ndip.model.diet.DietRelation;
import com.tenghong.ndip.service.diet.DietRelationService;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:42 2018/6/18
 */
@Service
public class DietRelationServiceImpl implements DietRelationService {

    @Autowired
    private DietRelationMapper relationMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public List<DietRelation> getDataGrip(Integer parentId, Integer parentType) {
        return relationMapper.selectByParentKey(parentId,parentType);
    }

    @Override
    public void save(DietRelation relation) {
        relationMapper.insertSelective(relation);
    }

    @Override
    public void update(DietRelation relation) {
        relationMapper.updateByPrimaryKeySelective(relation);
    }

    @Override
    public DietRelation getInfo(Integer id) {
        return relationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Integer reParentId, Integer reParentType) {
        relationMapper.delete(reParentId,reParentType);
    }

    @Override
    public void delete(Integer id) {
        relationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer getMenuId(Integer id, Integer type) {
        return relationMapper.getMenuId(id,type);
    }
}
