package com.tenghong.ndip.controller;

import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.diet.DietRelation;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.his.HisOmsStatus;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.diet.DietRelationService;
import com.tenghong.ndip.service.diet.ElementService;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.service.his.OmsStatusService;
import com.tenghong.ndip.service.sys.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 1:14 2018/6/2
 */
public class BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private DietRelationService relationService;

    @Autowired
    private OmsStatusService omsStatusService;

    @Autowired
    private CafeteriaService cafeteriaService;



    //获取结果集实例化对象
    protected Result getResultInstance(){
        return new Result();
    }

    //获取查询map
    protected Map<String,Object> getQueryMap(){ return new HashMap<>();}

    //生成用户token
    protected String getUserToken(){
        return UUID.randomUUID().toString();
    }

    //获取当前登陆用户
    protected SysUser getCurrentUser(String token){
        return userService.getUserByToken(token);
    }

    //获取当前用户权限树
    protected Result getResourcesTree(){
        return null;
    }

    //判断用户是否合法
    protected boolean userValid(String token){
        SysUser user = userService.getUserByToken(token);
        if (null == user) {
            return false;
        }
        return true;
    }

    //判断是否具有重复数据
    protected boolean dataValid(Object o,Set<Object> set){
        if (set.contains(o)){
            return false;
        }
        set.add(o);
        return true;
    }

    //保存营养素
    protected void saveElement(DietElement element){
        DietElement elementNew = elementService.getInfo(element.getGoalId(),element.getGoalType());
        if (elementNew != null){
            Integer elementId = elementNew.getElementId();
            BeanUtils.copyProperties(element,elementNew);
            elementNew.setElementId(elementId);
            elementService.update(elementNew);
        }else {
            elementService.save(element);
        }
    }

    //修改营养素
    protected void updateElement(DietElement element){
        elementService.update(element);
    }

    //保存膳食配置关系
    protected void saveDietRelation(DietRelation relation){ relationService.save(relation);}

    //查询膳食配置关系
    protected List<DietRelation> queryRelation(Integer parentId,Integer parentType){
        return relationService.getDataGrip(parentId,parentType);
    }

    //更新膳食配置关系
    protected  void updateRelation(DietRelation relation){
        relationService.update(relation); 
    }

    //保存订单状态
    protected  void saveOmsStatus(Integer omsId,Integer status,Integer userId,Date time){
        HisOmsStatus omsStatus = new HisOmsStatus();
        omsStatus.setOrderId(omsId);
        omsStatus.setStatus(status);
        omsStatus.setCreateBy(userId);
        omsStatus.setCreateTime(time);
        omsStatusService.save(omsStatus);
    }

    protected String getCafeteriaName(Integer id){
        HisCafeteria cafeteria = cafeteriaService.select(id);
        if (null == cafeteria)
            return "";
        return cafeteria.getCafeteriaName();
    }
}
