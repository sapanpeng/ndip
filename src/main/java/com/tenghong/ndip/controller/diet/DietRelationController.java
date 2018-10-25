package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.diet.DietRelation;
import com.tenghong.ndip.service.diet.DietRelationService;
import com.tenghong.ndip.service.diet.DishService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:26 2018/6/18
 */
@Controller
@RequestMapping("/admin")
public class DietRelationController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DietRelationController.class);

    @Autowired
    private DietRelationService relationService;

    //获取子级列表
    @RequestMapping(value = "/dietRelation/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam("parentId") Integer parentId,
                       @RequestParam("parentType")Integer parentType){
        Result result = getResultInstance();
        try{
            result.setData(relationService.getDataGrip(parentId,parentType));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //保存关系
    @RequestMapping(value = "/dietRelation/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("reGoalList") String relation,
                       @RequestParam("reParentId") Integer reParentId,
                       @RequestParam("reParentType") Integer reParentType){

        Result result = getResultInstance();
        try{
            relationService.delete(reParentId,reParentType);
            List<DietRelation> list = JSONArray.parseArray(relation, DietRelation.class);
            for (DietRelation item : list){
                item.setReParentId(reParentId);
                item.setReParentType(reParentType);
                saveDietRelation(item);
            }
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //更新关系
    @RequestMapping(value = "/dietRelation/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("reGoalList") String relation,
                         @RequestParam("reParentId") Integer reParentId,
                         @RequestParam("reParentType") Integer reParentType){
        Result result = getResultInstance();
        try{
            relationService.delete(reParentId,reParentType);
            List<DietRelation> list = JSONArray.parseArray(relation, DietRelation.class);
            for (DietRelation item : list){
                item.setReParentId(reParentId);
                item.setReParentType(reParentType);
                saveDietRelation(item);
            }
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //删除关系
    @RequestMapping(value = "/dietRelation/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("relationId") Integer id){
        Result result = getResultInstance();
        try{
            relationService.delete(id);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}
