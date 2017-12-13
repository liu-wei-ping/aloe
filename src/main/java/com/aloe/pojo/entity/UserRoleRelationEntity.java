package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "user_role_relation")
public class UserRoleRelationEntity extends BaseEntity {
    /**
     * 用户角色关系编号
     */
    @Column(name = "user_role_no")
    private String userRoleNo;

    /**
     * 用户编号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 获取用户角色关系编号
     *
     * @return user_role_no - 用户角色关系编号
     */
    public String getUserRoleNo() {
        return userRoleNo;
    }

    /**
     * 设置用户角色关系编号
     *
     * @param userRoleNo 用户角色关系编号
     */
    public void setUserRoleNo(String userRoleNo) {
        this.userRoleNo = userRoleNo == null ? null : userRoleNo.trim();
    }

    /**
     * 获取用户编号
     *
     * @return user_no - 用户编号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户编号
     *
     * @param userNo 用户编号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取角色编号
     *
     * @return role_no - 角色编号
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * 设置角色编号
     *
     * @param roleNo 角色编号
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }
}