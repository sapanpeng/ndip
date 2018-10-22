package com.tenghong.ndip.service.sys;

import com.tenghong.ndip.model.sys.SysDepartment;
import com.tenghong.ndip.model.vo.SelectVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:35 2018/6/3
 */
public interface DepartmentService {

    //获得部门列表
    List<SelectVo> getDepartmentList();

}
