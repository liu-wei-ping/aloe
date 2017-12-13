package com.aloe.pojo.vo;

public class RoleInfoVo extends BaseVo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 角色编号
	 */
	private String roleNo;

	/**
	 * 父级角色编号【0:表是最高级角色】
	 */
	private String parentNo;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 说明
	 */
	private String remark;

	/**
	 * 获取父级角色编号【0:表是最高级角色】
	 *
	 * @return parent_no - 父级角色编号【0:表是最高级角色】
	 */
	public String getParentNo() {
		return parentNo;
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
	 * 获取角色名称
	 *
	 * @return role_name - 角色名称
	 */
	public String getRoleName() {
		return roleName;
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
	 * 设置父级角色编号【0:表是最高级角色】
	 *
	 * @param parentNo
	 *            父级角色编号【0:表是最高级角色】
	 */
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo == null ? null : parentNo.trim();
	}

	/**
	 * 设置说明
	 *
	 * @param remark
	 *            说明
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 设置角色名称
	 *
	 * @param roleName
	 *            角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * 设置角色编号
	 *
	 * @param roleNo
	 *            角色编号
	 */
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo == null ? null : roleNo.trim();
	}
}