package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "role_info")
public class RoleInfoEntity extends BaseEntity {
    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 父级角色编号【0:表是最高级角色】
     */
    @Column(name = "parent_no")
    private String parentNo;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 说明
     */
    private String remark;

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

    /**
     * 获取父级角色编号【0:表是最高级角色】
     *
     * @return parent_no - 父级角色编号【0:表是最高级角色】
     */
    public String getParentNo() {
        return parentNo;
    }

    /**
     * 设置父级角色编号【0:表是最高级角色】
     *
     * @param parentNo 父级角色编号【0:表是最高级角色】
     */
    public void setParentNo(String parentNo) {
        this.parentNo = parentNo == null ? null : parentNo.trim();
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取说明
     *
     * @return remark - 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置说明
     *
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}