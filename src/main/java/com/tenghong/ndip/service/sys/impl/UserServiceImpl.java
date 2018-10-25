package com.tenghong.ndip.service.sys.impl;

import com.tenghong.ndip.mapper.sys.SysUserMapper;
import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.service.sys.UserService;
import com.tenghong.ndip.utils.PageInfo;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 22:50 2018/6/3
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public SysUser getUserByToken(String token) {
        return sysUserMapper.selectByToken(token);
    }

    @Override
    public SysUser getUserById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void getDataGrip(PageInfo pageInfo) {
        pageInfo.setRows(sysUserMapper.findPageCondition(pageInfo));
        pageInfo.setRecords(sysUserMapper.findPageCount(pageInfo));
    }

    @Override
    public void save(SysUser user) {
        sysUserMapper.insertSelective(user);
    }

    @Override
    public void update(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer vaildUser(String userName) {
        String sql = "select count(1) from sys_user where user_name = #{userName}";
        return sqlMapper.selectOne(sql,userName,int.class);
    }

    @Override
    public String vaildPwd(String userName) {
        String sql = "select password from sys_user where user_name = #{userName}";
        return sqlMapper.selectOne(sql,userName,String.class);
    }

    @Override
    public String vaildUserStatus(String userName) {
        String sql = "select status from sys_user where user_name = #{userName}";
        return sqlMapper.selectOne(sql,userName,String.class);
    }

    @Override
    public Boolean vaildUserType(String userName) {
        String sql = "select user_type from sys_user where user_name = #{userName}";
        String userType = sqlMapper.selectOne(sql,userName,String.class);
        if (userType != null && userType.equals("3"))
            return true;
        return false;
    }
}
