package com.tenghong.ndip.model.sys;

import java.io.Serializable;

/**
 * sys_department
 * @author 
 */
public class SysDepartment implements Serializable {
    /**
     * 部门id
     */
    private Integer id;

    /**
     * 部门
     */
    private String department;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}