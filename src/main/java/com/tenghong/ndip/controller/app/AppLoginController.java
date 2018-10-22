package com.tenghong.ndip.controller.app;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.sys.UserService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 20:30 2018/6/24
 */
@Controller
@RequestMapping("/api")
public class AppLoginController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("userName")String userName,
                        @RequestParam("password")String password){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> queryMap = getQueryMap();
        try{
            //校验用户是否存在
            if (userService.vaildUser(userName).toString().equals("0")){
                result.setState(0);
                result.setMsg("用户名不存在");
                return result;
            }

            //检验密码
            if (!userService.vaildPwd(userName).equals(password)){
                result.setState(0);
                result.setMsg("用户名或密码错误");
                return result;
            }
            //校验用户是否正常使用
            if (!userService.vaildUserStatus(userName).equals("1")){
                result.setState(0);
                result.setMsg("用户状态异常");
                return result;
            }

            //检验密码
            if (!userService.vaildUserType(userName)){
                result.setState(0);
                result.setMsg("用户不是订餐员");
                return result;
            }
            queryMap.put("userName",userName);
            queryMap.put("password",password);
            PageInfo pageInfo = new PageInfo(1,1,"create_time","desc");
            pageInfo.setCondition(queryMap);
            userService.getDataGrip(pageInfo);
            SysUser user = (SysUser) pageInfo.getRows().get(0);
            map.put("token",user.getUserToken());
            result.setData(map);
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
