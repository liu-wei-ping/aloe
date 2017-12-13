package com.aloe.constants;

/**
 * @author liu wp
 * @date 2017年9月26日
 */
public class SysConstantsConfig {
	// 接口返回失败
	public static final String DEFAULT_RETURN_FAIL_CODE = "x500";
	// 接口返回失败消息信息
	public static final String DEFAULT_RETURN_FAIL_MESSAGE = "fail";
	// 接口返回成功code
	public static final String DEFAULT_RETURN_SUCCESS_CODE = "200";
	// 接口返回成功message
	public static final String DEFAULT_RETURN_SUCCESS_MESSAGE = "success";

	// 渠道【0:pc，1:手机，2：微信，-1：其它】
	public static final String REG_SOURCE_PC = "0";
	public static final String REG_SOURCE_MOBILE = "1";
	public static final String REG_SOURCE_WX = "2";
	public static final String REG_SOURCE_OTHER = "-1";
	// 用户状态 【0：启用 ，1：停用】
	public static final Integer USER_STATUS_LOCKED = 1;
	public static final Integer USER_STATUS_UNLOCKED = 0;

	// 散列的次数，比如散列两次，相当于 md5(md5(""))
	public static final int SHIRO_HASH_ITERATIONS = 2;

}
