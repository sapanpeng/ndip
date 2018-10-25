package com.tenghong.ndip.service.diet.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.tenghong.ndip.mapper.diet.DietMatlMapper;
import com.tenghong.ndip.mapper.diet.IntlFoodMapper;
import com.tenghong.ndip.mapper.diet.IntlFoodTypeMapper;
import com.tenghong.ndip.model.diet.DietMatl;
import com.tenghong.ndip.model.diet.DietMatlType;
import com.tenghong.ndip.model.diet.IntlFood;
import com.tenghong.ndip.model.diet.IntlFoodType;
import com.tenghong.ndip.service.diet.MaterialService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:42 2018/6/12
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private IntlFoodTypeMapper foodTypeMapper;

    @Autowired
    private IntlFoodMapper foodMapper;

    @Autowired
    private DietMatlMapper matlMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public List<IntlFoodType> getIntlTypeDataGrip() {
        List<IntlFoodType> pList = foodTypeMapper.selectParentType();
        for (IntlFoodType type : pList){
            type.setList(foodTypeMapper.selectChildType(type.getId()));
        }
        return pList;
    }

    @Override
    public void getIntlDataGrip(Integer typeId, PageInfo pageInfo,Map<String,Object> map,Integer level,String name) {
        List<Integer> list = new ArrayList<>();
        if (level != null && typeId != null) {
        	if (level.toString().equals("1")){
        		String sql  = "select id from intl_food_type where pid = #{typeId} and level = 2";
        		list = sqlMapper.selectList(sql,typeId,int.class);
        	}else{
        		list.add(typeId);
        	}
        }
        
        if (!StringUtils.isEmpty(name)) {
        	map.put("name", name);
        }
        
        pageInfo.setCondition(map);
        pageInfo.setList(list);
        pageInfo.setRows(foodMapper.findPageCondition(pageInfo));
        Integer a = foodMapper.findPageCount(pageInfo);
        pageInfo.setRecords(a);
    }

    @Override
    public IntlFood getInfo(String id) {
        return foodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DietMatlType> getMatlTypeDataGrip() {
        String sql = "select id,name from diet_matl_type where status = 1 order by sort asc";
        return sqlMapper.selectList(sql, DietMatlType.class);
    }

    @Override
    public void getDataGrip(PageInfo pageInfo) {
        pageInfo.setRows(matlMapper.findPageCondition(pageInfo));
        pageInfo.setRecords(matlMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(DietMatl matl) {
        matlMapper.insertSelective(matl);
    }

    @Override
    public DietMatl select(Integer id) {
        return matlMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(DietMatl matl) {
        matlMapper.updateByPrimaryKeySelective(matl);
    }

    @Override
    public DietMatl getInfo(Integer id) {
        return matlMapper.getInfo(id);
    }
}
