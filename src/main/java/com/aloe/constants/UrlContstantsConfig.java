package com.aloe.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liu_wp
 * @date 2017年10月14日
 * @see
 */
public class UrlContstantsConfig {
	// 登录路径
	public static final String LOGIN_URL = "/login";
	// 登录请求
	public static final String LOGIN_CHECK_URL = "/checklogin";
	// 退出登录路径
	public static final String LOGOUT_URL = "/logout";
	// 注册路径
	public static final String REGISTER_URL = "/register";
	// 注册请求路径
	public static final String REGISTER_CHECK_URL = "/checkregister";
	// 登录成功路径
	public static final String LOGIN_SUCCESS_URL = "/";
	// 默认访问路径
	public static final String DEFAULT_VISIT_URL = "/";
	// 未对其授权的资源时,所显示的页面
	public static final String UNAUTHORIZED_URL = "/pages/403";
	// 默认访问错误路径
	public static final String DEFAULT_ERROR_URL = "";
	// 默认静态资源路径
	public static final String DEFAULT_STATIC_URL = "/static/**";
	// 无需系统验证就可访问路径
	public static final Map<String, String> ANON_MAP = new LinkedHashMap<String, String>();
	static {
		ANON_MAP.put(LOGOUT_URL, "anon");
		ANON_MAP.put(DEFAULT_STATIC_URL, "anon");
		ANON_MAP.put(DEFAULT_VISIT_URL, "anon");
		ANON_MAP.put(LOGIN_URL, "anon");
		ANON_MAP.put(LOGIN_CHECK_URL, "anon");
		ANON_MAP.put(REGISTER_URL, "anon");
		ANON_MAP.put(REGISTER_CHECK_URL, "anon");

	}
}
