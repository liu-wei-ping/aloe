package com.aloe.pojo.entity;

import javax.persistence.*;

@Table(name = "menu_info")
public class MenuInfoEntity extends BaseEntity {
    /**
     * 菜单编号
     */
    @Column(name = "menu_no")
    private String menuNo;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父级菜单编号【0表示最高级菜单】
     */
    @Column(name = "parent_menu_no")
    private String parentMenuNo;

    /**
     * 菜单路径
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 菜单类型
     */
    @Column(name = "menu_type")
    private String menuType;

    /**
     * 是否需要登录【Y : 是；N：否】
     */
    @Column(name = "need_login")
    private String needLogin;

    private String remark;

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
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取父级菜单编号【0表示最高级菜单】
     *
     * @return parent_menu_no - 父级菜单编号【0表示最高级菜单】
     */
    public String getParentMenuNo() {
        return parentMenuNo;
    }

    /**
     * 设置父级菜单编号【0表示最高级菜单】
     *
     * @param parentMenuNo 父级菜单编号【0表示最高级菜单】
     */
    public void setParentMenuNo(String parentMenuNo) {
        this.parentMenuNo = parentMenuNo == null ? null : parentMenuNo.trim();
    }

    /**
     * 获取菜单路径
     *
     * @return menu_url - 菜单路径
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单路径
     *
     * @param menuUrl 菜单路径
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取菜单类型
     *
     * @return menu_type - 菜单类型
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型
     *
     * @param menuType 菜单类型
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    /**
     * 获取是否需要登录【Y : 是；N：否】
     *
     * @return need_login - 是否需要登录【Y : 是；N：否】
     */
    public String getNeedLogin() {
        return needLogin;
    }

    /**
     * 设置是否需要登录【Y : 是；N：否】
     *
     * @param needLogin 是否需要登录【Y : 是；N：否】
     */
    public void setNeedLogin(String needLogin) {
        this.needLogin = needLogin == null ? null : needLogin.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}