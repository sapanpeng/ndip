package com.tenghong.ndip.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.service.sys.DepartmentService;
import com.tenghong.ndip.service.sys.UserService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 22:26 2018/6/3
 */
@Controller
@RequestMapping("/admin")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CafeteriaService cafeteriaService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows,
                       @RequestParam(value = "userType", required = false, defaultValue = "")Integer userType,
                       @RequestParam(value = "cafeteriaId", required = false, defaultValue = "")Integer cafeteriaId){
        Result result = getResultInstance();
        Map<String,Object> map = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "create_time", "desc");
            map.put("userType",userType);
            map.put("cafeteriaId",cafeteriaId);
            pageInfo.setCondition(map);
            userService.getDataGrip(pageInfo);
            result.setData(pageInfo);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestParam("token") String token,
                      @RequestParam("userName") String userName,
                      @RequestParam("realName") String realName,
                      @RequestParam("birthday") Date birthday,
                      @RequestParam("sex") Integer sex,
                      @RequestParam("idCard") String idCard,
                      @RequestParam("mobileTel") String mobileTel,
                      @RequestParam("email") String email,
                      @RequestParam("departmentId") Integer departmentId,
                      @RequestParam("department") String department,
                      @RequestParam("cafeteriaId") String cafeteriaId,
                      @RequestParam("cafeteria") String cafeteria,
                      @RequestParam("userType") Integer userType,
                      @RequestParam("status") Integer status,
                      @RequestParam("password") String password,
                      @RequestParam(value = "memo", required = false, defaultValue = "") String memo){
        Result result = getResultInstance();
        try{
            //校验用户是否存在
            if (userService.vaildUser(userName)>0){
                result.setState(0);
                result.setMsg("用户名已经存在");
                return result;
            }
            SysUser user = new SysUser();
            user.setUserName(userName);
            user.setRealName(realName);
            user.setBirthday(birthday);
            user.setSex(sex);
            user.setIdCard(idCard);
            user.setMobileTel(mobileTel);
            user.setEmail(email);
            user.setDepartmentId(departmentId);
            user.setDepartment(department);
            user.setCafeteriaId(cafeteriaId);
            String[] listStr = cafeteriaId.split(",");
            StringBuffer buff = new StringBuffer();
            for (String str : listStr) {
            	HisCafeteria hisCafeteria = cafeteriaService.select(Integer.parseInt(str));
            	if (buff.length() > 0) {
            		buff.append(",");
            	}
            	buff.append(hisCafeteria.getCafeteriaName());
            	user.setCafeteria(buff.toString());
            }
            user.setUserType(userType);
            user.setStatus(status);
            user.setPassword(password);
            user.setMemo(memo);
            user.setCreateTime(new Date());
            user.setCreateBy(getCurrentUser(token).getUserId());
            user.setUserToken(getUserToken());
            userService.save(user);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    private void parseArray(String cafeteriaId, Class<String> class1) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/user/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result editPage(@RequestParam("userId") Integer userId){
        Result result = getResultInstance();
        try{
            result.setData(userService.getUserById(userId));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("userId") Integer userId,
                       @RequestParam("token") String token,
                       @RequestParam("userName") String userName,
                       @RequestParam("realName") String realName,
                       @RequestParam("birthday") Date birthday,
                       @RequestParam("sex") Integer sex,
                       @RequestParam("idCard") String idCard,
                       @RequestParam("mobileTel") String mobileTel,
                       @RequestParam("email") String email,
                       @RequestParam("departmentId") Integer departmentId,
                       @RequestParam("department") String department,
                       @RequestParam("cafeteriaId") String cafeteriaId,
                       @RequestParam("cafeteria") String cafeteria,
                       @RequestParam("userType") Integer userType,
                       @RequestParam("status") Integer status,
                       @RequestParam("password") String password,
                       @RequestParam(value = "memo", required = false, defaultValue = "") String memo){
        Result result = getResultInstance();
        try{
            if (!userName.equals(userName) && userService.vaildUser(userName)>0){
                result.setState(0);
                result.setMsg("用户名已经存在");
                return result;
            }
            SysUser user = userService.getUserById(userId);
            user.setUserName(userName);
            user.setRealName(realName);
            user.setBirthday(birthday);
            user.setSex(sex);
            user.setIdCard(idCard);
            user.setMobileTel(mobileTel);
            user.setEmail(email);
            user.setDepartmentId(departmentId);
            user.setDepartment(department);
            user.setCafeteriaId(cafeteriaId);
            
            String[] listStr = cafeteriaId.split(",");
            StringBuffer buff = new StringBuffer();
            for (String str : listStr) {
            	HisCafeteria hisCafeteria = cafeteriaService.select(Integer.parseInt(str));
            	if (buff.length() > 0) {
            		buff.append(",");
            	}
            	buff.append(hisCafeteria.getCafeteriaName());
            	user.setCafeteria(buff.toString());
            }
            
            user.setUserType(userType);
            user.setStatus(status);
            user.setPassword(password);
            user.setMemo(memo);
            user.setUpdateTime(new Date());
            user.setUpdateBy(getCurrentUser(token).getUserId());
            userService.update(user);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

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
            queryMap.put("userName",userName);
            queryMap.put("password",password);
            PageInfo pageInfo = new PageInfo(1,1,"create_time","desc");
            pageInfo.setCondition(queryMap);
            userService.getDataGrip(pageInfo);
            SysUser user = (SysUser) pageInfo.getRows().get(0);
            map.put("token",user.getUserToken());
            map.put("realName",user.getRealName());
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

    @RequestMapping(value = "/user/change",method = RequestMethod.POST)
    @ResponseBody
    public Result change(@RequestParam("userId") Integer userId,
                         @RequestParam("status") Integer status){
        Result result = getResultInstance();
        try{
            SysUser user = userService.getUserById(userId);
            user.setStatus(status);
            userService.update(user);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/department/list",method = RequestMethod.POST)
    @ResponseBody
    public Result departmentList(){
        Result result = getResultInstance();
        try{
            result.setData(departmentService.getDepartmentList());
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
