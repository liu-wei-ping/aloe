package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "menu_right_relation")
public class MenuRightRelationEntity extends BaseEntity {
    /**
     * 菜单权限关系编号
     */
    @Column(name = "menu_right_no")
    private String menuRightNo;

    /**
     * 菜单编号
     */
    @Column(name = "menu_no")
    private String menuNo;

    /**
     * 权限编号
     */
    @Column(name = "right_no")
    private String rightNo;

    /**
     * 获取菜单权限关系编号
     *
     * @return menu_right_no - 菜单权限关系编号
     */
    public String getMenuRightNo() {
        return menuRightNo;
    }

    /**
     * 设置菜单权限关系编号
     *
     * @param menuRightNo 菜单权限关系编号
     */
    public void setMenuRightNo(String menuRightNo) {
        this.menuRightNo = menuRightNo == null ? null : menuRightNo.trim();
    }

    /**
     * 获取菜单编号
     *
     * @return menu_no - 菜单编号
     */
    public String getMenuNo() {
        return menuNo;
    }

    /**
     * 设置菜单编号
     *
     * @param menuNo 菜单编号
     */
    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo == null ? null : menuNo.trim();
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
}