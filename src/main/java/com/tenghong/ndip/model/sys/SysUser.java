package com.tenghong.ndip.model.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    private String userToken;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机号
     */
    private String mobileTel;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 性别  0男 1女
     */
    private Integer sex;

    /**
     * 用户类型 1管理员  2普通用户  3送餐员
     */
    private Integer userType;

    /**
     * 对应食堂id（管理员可查看所有食堂数据）
     */
    private String cafeteriaId;

    private String cafeteria;

    private String department;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 修改人id
     */
    private Integer updateBy;

    /**
     * 1:启用 2:停用 3:删除
     */
    private Integer status;

    /**
     * 备注
     */
    private String memo;

    private Integer permissionState;

    private static final long serialVersionUID = 1L;


    public Integer getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(Integer permissionState) {
        this.permissionState = permissionState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(String cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(String cafeteria) {
        this.cafeteria = cafeteria;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}