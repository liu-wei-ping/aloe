package com.aloe.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.aloe.utils.DateUtil;

@Table(name = "user_info")
public class UserInfoEntity extends BaseEntity {
	/**
	 * 用户唯一标识
	 */
	@Column(name = "user_no")
	private String userNo;

	/**
	 * 用户名称
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 登录密码
	 */
	@Column(name = "login_pwd")
	private String loginPwd;

	/**
	 * 用户头像
	 */
	@Column(name = "h_portrait")
	private String hPortrait;

	/**
	 * 生日
	 */
	private String birthday;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮件
	 */
	private String email;

	/**
	 * 手机
	 */
	private String phone;

	/**
	 * 注册来源【0：PC；1 : 手机；2：微信；-1：其它】
	 */
	@Column(name = "reg_source")
	private Integer regSource;

	private String remark;

	public UserInfoEntity() {
		this.createTime = DateUtil.getNowTimeStamp();
	}

	/**
	 * 获取地址
	 *
	 * @return address - 地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 获取生日
	 *
	 * @return birthday - 生日
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 获取邮件
	 *
	 * @return email - 邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 获取用户头像
	 *
	 * @return h_portrait - 用户头像
	 */
	public String gethPortrait() {
		return hPortrait;
	}

	/**
	 * 获取登录密码
	 *
	 * @return login_pwd - 登录密码
	 */
	public String getLoginPwd() {
		return loginPwd;
	}

	/**
	 * 获取手机
	 *
	 * @return phone - 手机
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 获取注册来源【0：PC；1 : WB；2：其他】
	 *
	 * @return reg_source - 注册来源【0：PC；1 : WB；2：其他】
	 */
	public Integer getRegSource() {
		return regSource;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 获取用户名称
	 *
	 * @return user_name - 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 获取用户唯一标识
	 *
	 * @return user_no - 用户唯一标识
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * 设置地址
	 *
	 * @param address
	 *            地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * 设置生日
	 *
	 * @param birthday
	 *            生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	/**
	 * 设置邮件
	 *
	 * @param email
	 *            邮件
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * 设置用户头像
	 *
	 * @param hPortrait
	 *            用户头像
	 */
	public void sethPortrait(String hPortrait) {
		this.hPortrait = hPortrait == null ? null : hPortrait.trim();
	}

	/**
	 * 设置登录密码
	 *
	 * @param loginPwd
	 *            登录密码
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd == null ? null : loginPwd.trim();
	}

	/**
	 * 设置手机
	 *
	 * @param phone
	 *            手机
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * 设置注册来源【0：PC；1 : WB；2：其他】
	 *
	 * @param regSource
	 *            注册来源【0：PC；1 : WB；2：其他】
	 */
	public void setRegSource(Integer regSource) {
		this.regSource = regSource;
	}

	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 设置用户名称
	 *
	 * @param userName
	 *            用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * 设置用户唯一标识
	 *
	 * @param userNo
	 *            用户唯一标识
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}
}