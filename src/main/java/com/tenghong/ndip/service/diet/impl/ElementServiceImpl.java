package com.tenghong.ndip.service.diet.impl;

import com.tenghong.ndip.mapper.diet.DietElementMapper;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.service.diet.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:43 2018/6/15
 */
@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private DietElementMapper elementMapper;

    @Override
    public void save(DietElement element) {
        elementMapper.insertSelective(element);
    }

    @Override
    public void update(DietElement element) {
        elementMapper.updateByPrimaryKeySelective(element);
    }

    @Override
    public DietElement getInfo(Integer goalId, Integer goalType) {
        return elementMapper.selectByCondition(goalId,goalType);
    }
}
