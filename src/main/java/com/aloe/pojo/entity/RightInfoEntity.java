package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "right_info")
public class RightInfoEntity extends BaseEntity {
    /**
     * 权限编号
     */
    @Column(name = "right_no")
    private String rightNo;

    @Column(name = "right_name")
    private String rightName;

    /**
     * 权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
     */
    @Column(name = "right_type")
    private String rightType;

    /**
     * 说明
     */
    private String remark;

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
     * @return right_name
     */
    public String getRightName() {
        return rightName;
    }

    /**
     * @param rightName
     */
    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    /**
     * 获取权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
     *
     * @return right_type - 权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
     */
    public String getRightType() {
        return rightType;
    }

    /**
     * 设置权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
     *
     * @param rightType 权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
     */
    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
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