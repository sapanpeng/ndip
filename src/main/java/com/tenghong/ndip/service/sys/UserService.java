package com.tenghong.ndip.service.sys;

import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 22:49 2018/6/3
 */
public interface UserService {
    //根据用户token获得用户实体
    SysUser getUserByToken(String token);

    //根据用户Id获得用户实体
    SysUser getUserById(Integer userId);

    //获取用户列表
    void getDataGrip(PageInfo pageInfo);

    //保存用户
    void save(SysUser user);

    //保存用户
    void update(SysUser user);

    //校验用户名
    Integer vaildUser(String userName);

    //校验密码
    String vaildPwd(String userName);

    //校验用户是否正常使用
    String vaildUserStatus(String userName);

    //校验用户是否为送餐员
    Boolean vaildUserType(String userName);
}
