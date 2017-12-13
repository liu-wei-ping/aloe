package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "role_right_relation")
public class RoleRightRelationEntity extends BaseEntity {
    /**
     * 角色权限关系编号
     */
    @Column(name = "role_right_no")
    private String roleRightNo;

    /**
     * 权限编号
     */
    @Column(name = "right_no")
    private String rightNo;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 获取角色权限关系编号
     *
     * @return role_right_no - 角色权限关系编号
     */
    public String getRoleRightNo() {
        return roleRightNo;
    }

    /**
     * 设置角色权限关系编号
     *
     * @param roleRightNo 角色权限关系编号
     */
    public void setRoleRightNo(String roleRightNo) {
        this.roleRightNo = roleRightNo == null ? null : roleRightNo.trim();
    }

    /**
     * 获取权限编号
     *
     * @return right_no - 权限编号
     */
    public String getRightNo() {
        return rightNo;
    }

    /**
     * 设置权限编号
     *
     * @param rightNo 权限编号
     */
    public void setRightNo(String rightNo) {
        this.rightNo = rightNo == null ? null : rightNo.trim();
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