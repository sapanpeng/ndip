package com.tenghong.ndip.service.diet.impl;

import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.mapper.diet.DietDishPkgMapper;
import com.tenghong.ndip.model.diet.DietDishPkg;
import com.tenghong.ndip.service.diet.DishPkgService;
import com.tenghong.ndip.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:44 2018/6/19
 */
@Service
public class DishPkgServiceImpl implements DishPkgService {

    @Autowired
    private DietDishPkgMapper dietDishPkgMapper;

    @Override
    public void getDataGrip(PageInfo pageInfo,String path) {
        List<DietDishPkg> list = dietDishPkgMapper.findPageCondition(pageInfo);
        for (DietDishPkg diet : list){
            diet.setIconVo(NdipUtils.ndipInstance().getImageUrl(diet.getIcon(),path));
        }
        pageInfo.setRows(list);
        pageInfo.setRecords(dietDishPkgMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(DietDishPkg dish) {
        dietDishPkgMapper.insertSelective(dish);
    }

    @Override
    public DietDishPkg getInfo(Integer id,String path) {
        DietDishPkg dish = dietDishPkgMapper.getInfo(id);
        dish.setIconVo(NdipUtils.ndipInstance().getImageUrl(dish.getIcon(),path));
        return dish;
    }

    @Override
    public DietDishPkg selectOne(Integer id) {
        return dietDishPkgMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(DietDishPkg dish) {
        dietDishPkgMapper.updateByPrimaryKeySelective(dish);
    }

}
