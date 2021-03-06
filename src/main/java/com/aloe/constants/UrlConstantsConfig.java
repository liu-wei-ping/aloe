package com.aloe.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liu_wp
 * @date 2017年10月14日
 * @see
 */
public class UrlConstantsConfig {

    /******************************************************************************
     * 系统页面请求路径配置
     * ****************************************************************************/
    // 默认访问路径
    public static final String DEFAULT_VISIT_URL = "/";
    // 登录路径
    public static final String LOGIN_URL = "/login";
    // 登录请求路径
    public static final String LOGIN_CHECK_URL = "/user-login";
    // 退出登录路径
    public static final String LOGOUT_URL = "/logout";
    // 注册路径
    public static final String REGISTER_URL = "/register";
    // 登录成功路径
    public static final String LOGIN_SUCCESS_URL = "/index";
    // 注册请求路径
    public static final String REGISTER_CHECK_URL = "/user-register";
    // 默认静态资源路径
    public static final String DEFAULT_STATIC_URL = "/static/**";
    public static final String DEFAULT_WEBJARS_URL = "/webjars/**";
    // 未对其授权的资源时路径
    public static final String UNAUTHORIZED_URL = "/pages/403";
    //favicon
    public static final String FAVICON_ICO_URL = "/favicon.ico";
    //测试类
    public static final String DEMO_TEST_URL = "/hello/**";
    //wechat api url
    public static final String WECHAT_API_URL = "/wechat/**";
    //druid 监控
    public static final String DRUID_MONITOR_URL = "/druid/**";
    //系统验证访问路径
    public static final Map<String, String> ANON_MAP = new LinkedHashMap<String, String>();

    static {
        //无需验证路径
        ANON_MAP.put(DEFAULT_STATIC_URL, "anon");
        ANON_MAP.put(DEFAULT_WEBJARS_URL, "anon");
        ANON_MAP.put(LOGOUT_URL, "anon");
        ANON_MAP.put(DEFAULT_VISIT_URL, "anon");
        ANON_MAP.put(LOGIN_URL, "anon");
        ANON_MAP.put(LOGIN_CHECK_URL, "anon");
        ANON_MAP.put(REGISTER_URL, "anon");
        ANON_MAP.put(REGISTER_CHECK_URL, "anon");
        ANON_MAP.put(FAVICON_ICO_URL, "anon");
        ANON_MAP.put(DEMO_TEST_URL, "anon");
        ANON_MAP.put(DRUID_MONITOR_URL, "anon");
        ANON_MAP.put(WECHAT_API_URL, "anon");
        //登录请求
//        ANON_MAP.put(UrlConstantsConfig.LOGIN_CHECK_URL, "login_authc");
        //默认都要验证
        ANON_MAP.put("/**", "authc");

    }

    /******************************************************************************
     * 系统页面配置
     * ****************************************************************************/
    // 默认访问页面
    public static final String DEFAULT_VISIT_PAGE = "index";
    //用户注册页面
    public static final String REGISTER_PAGE = "register";
    //登录成功页面
    public static final String LOGIN_SUCCESS_PAGE = "index";
    //登录成功中转页面
    public static final String REGISTER_TRANSFER_PAGE = "jump";
    // 默认访问错误页面
    public static final String DEFAULT_ERROR_PAGE = "pages/error";
    //用户没有权限页面
    public static final String UNAUTHORIZED_ROLE_PAGE = "pages/403";


}
