package com.tenghong.ndip.controller.sys;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.service.sys.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 22:28 2018/6/3
 */
@Controller
@RequestMapping("/admin")
public class ResourcesController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourcesController.class);

    @Autowired
    private ResourcesService resourcesService;

    //查询用户权限资源
    @RequestMapping(value = "/resources/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "token", required = false, defaultValue = "") String token){
        Result result = getResultInstance();
        try{
            Integer userId = null == getCurrentUser(token) ? null : getCurrentUser(token).getUserId();
            result.setData(resourcesService.list(userId));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("Server Exception");
            result.setState(0);
        }
        return result;
    }

    //查询用户拥有菜单资源
    @RequestMapping(value = "/resources/info",method = RequestMethod.POST)
    @ResponseBody
    public Result info(@RequestParam("token") String token){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            map.put("list",resourcesService.info(getCurrentUser(token).getUserId()));
            result.setData(map);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("Server Exception");
            result.setState(0);
        }
        return result;
    }

    //添加用户权限
    @RequestMapping(value = "/resources/save",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestParam("userList") List<Integer> userList,
                      @RequestParam("resourcesList") List<Integer> resourcesList){
        Result result = getResultInstance();
        try{
            if (userList.size() == 0 || resourcesList.size() == 0){
                result.setState(0);
                result.setMsg("数据不能为空");
                return result;
            }
            resourcesService.save(userList,resourcesList);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("Server Exception");
            result.setState(0);
        }
        return result;
    }

    //clean
    @RequestMapping(value = "/resources/clean",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("userId") Integer userId){
        Result result = getResultInstance();
        try{
            resourcesService.delete(userId);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("Server Exception");
            result.setState(0);
        }
        return result;
    }
}
