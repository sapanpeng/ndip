package com.tenghong.ndip.service.diet.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.diet.DietDishMapper;
import com.tenghong.ndip.model.diet.DietDish;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.service.diet.DishService;
import com.tenghong.ndip.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:52 2018/6/13
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DietDishMapper dietDishMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo,String path) {
        List<DietDish> list = dietDishMapper.findPageCondition(pageInfo);
        for (DietDish diet : list){
            diet.setIconVo(NdipUtils.ndipInstance().getImageUrl(diet.getIcon(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(dietDishMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(DietDish dish) {
        dietDishMapper.insertSelective(dish);
    }

    @Override
    public DietDish getInfo(Integer id,String path) {
        DietDish dish = dietDishMapper.getInfo(id);
        dish.setIconVo(NdipUtils.ndipInstance().getImageUrl(dish.getIcon(),path));
        return dish;
    }

    @Override
    public DietDish selectOne(Integer id) {
        return dietDishMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(DietDish dietDish) {
        dietDishMapper.updateByPrimaryKeySelective(dietDish);
    }
}
