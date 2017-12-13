package com.aloe.pojo.vo;

/**
 * @author liu_wp
 * @date 2017年10月12日
 * @see
 */
public class RightInfoVo {
	/**
	 * 权限编号
	 */
	private String rightNo;

	private String rightName;

	/**
	 * 权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
	 */
	private String rightType;

	/**
	 * 说明
	 */
	private String remark;

	/**
	 * 获取说明
	 *
	 * @return remark - 说明
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @return right_name
	 */
	public String getRightName() {
		return rightName;
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
	 * 获取权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
	 *
	 * @return right_type -
	 *         权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
	 */
	public String getRightType() {
		return rightType;
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
	 * @param rightName
	 */
	public void setRightName(String rightName) {
		this.rightName = rightName == null ? null : rightName.trim();
	}

	/**
	 * 设置权限编号
	 *
	 * @param rightNo
	 *            权限编号
	 */
	public void setRightNo(String rightNo) {
		this.rightNo = rightNo == null ? null : rightNo.trim();
	}

	/**
	 * 设置权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
	 *
	 * @param rightType
	 *            权限类型【MENU：菜单访问权限；ELEMENT：页面元素可见权限；OPERATION：操作权限；FILE：文件可编辑权限】
	 */
	public void setRightType(String rightType) {
		this.rightType = rightType == null ? null : rightType.trim();
	}
}
