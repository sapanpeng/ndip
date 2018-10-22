package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.dto.ImageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 22:50 2018/6/18
 */
@Controller
@RequestMapping("/admin")
public class DietElementController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DietElementController.class);


    //保存营养素
    @RequestMapping(value = "/element/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("element") String element){
        Result result = getResultInstance();
        try{
            List<DietElement> list = JSONArray.parseArray("["+element+"]", DietElement.class);
            saveElement(list.get(0));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //修改营养素
    @RequestMapping(value = "/element/update",method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("element") String element){
        Result result = getResultInstance();
        try{
            List<DietElement> list = JSONArray.parseArray(element, DietElement.class);
            updateElement(list.get(0));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

}
