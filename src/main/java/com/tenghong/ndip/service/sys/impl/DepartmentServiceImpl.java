package com.tenghong.ndip.service.sys.impl;

import com.tenghong.ndip.model.sys.SysDepartment;
import com.tenghong.ndip.model.vo.SelectVo;
import com.tenghong.ndip.service.sys.DepartmentService;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:36 2018/6/3
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private SqlMapper sqlMapper;


    @Override
    public List<SelectVo> getDepartmentList() {
        String sql = "select id as `value`,department as `key` from sys_department";
        return sqlMapper.selectList(sql,SelectVo.class);
    }
}
