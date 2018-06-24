package com.aloe.config;

import java.util.Map;

import javax.servlet.Filter;

import com.aloe.constants.UrlConstantsConfig;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.aloe.constants.SysConstantsConfig;
import com.aloe.filter.AuthcFormAuthenticationFilter;
import com.aloe.filter.LoginFormAuthenticationFilter;
import com.aloe.shiro.MyShiroFilterFactoryBean;
import com.aloe.shiro.matcher.RetryLimitHashedCredentialsMatcher;
import com.aloe.shiro.realm.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
@Configuration
public class ShiroConfig {
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),
	 * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)
	 * 和AuthorizationAttributeSourceAdvisor)即可实现此功能
	 *
	 * @return
	 */
	@Bean
	@DependsOn({ "lifecycleBeanPostProcessor" })
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
		return ehCacheManager;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码; ） 可以扩展凭证匹配器，<br>
	 * 实现 输入密码错误次数后锁定等功能
	 *
	 * @return
	 */
	@Bean(name = "credentialsMatcher")
	public RetryLimitHashedCredentialsMatcher hashedCredentialsMatcher() {
		RetryLimitHashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(
				ehCacheManager());
		// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		// 散列的次数，比如散列两次，相当于 md5(md5(""));
		hashedCredentialsMatcher.setHashIterations(SysConstantsConfig.SHIRO_HASH_ITERATIONS);
		// storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}

	/**
	 * Shiro生命周期处理器
	 *
	 * @return
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {

		System.out.println("ShiroConfiguration.rememberMeCookie()");
		// 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// <!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}

	/**
	 * cookie管理对象;
	 *
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		System.out.println("ShiroConfiguration.rememberMeManager()");
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}

	/**
	 * 安全验证管理器
	 *
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		logger.info("注入Shiro的Web过滤器-->securityManager", ShiroFilterFactoryBean.class);
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setCacheManager(ehCacheManager());
		securityManager.setRememberMeManager(rememberMeManager());
		securityManager.setRealm(userRealm());
		return securityManager;
	}

	/**
	 * 添加ShiroDialect 为了在thymeleaf里使用shiro的标签的bean
	 *
	 * @return
	 */
	@Bean(name = "shiroDialect")
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	/**
	 * Shiro的Web过滤器Factory 命名:shiroFilter
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public MyShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		logger.info("注入Shiro的Web过滤器-->shiroFilter", MyShiroFilterFactoryBean.class);
		MyShiroFilterFactoryBean shiroFilterFactoryBean = new MyShiroFilterFactoryBean();
		// 注入自定义的Filter
		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		filters.put("authc", new AuthcFormAuthenticationFilter());
		filters.put("login_authc", new LoginFormAuthenticationFilter());
		shiroFilterFactoryBean.setFilters(filters);
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 登录页面路径 默认路径
		shiroFilterFactoryBean.setLoginUrl(UrlConstantsConfig.DEFAULT_VISIT_URL);
		// shiroFilterFactoryBean.setSuccessUrl("/index");
		shiroFilterFactoryBean.setUnauthorizedUrl(UrlConstantsConfig.UNAUTHORIZED_URL);
		// 定义shiro过滤链 Map结构 从上向下顺序执行 将 /**放在最为下边
		// key: 第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值。
		// logout:配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		// anon:它对应的过滤器里面是空的,什么都没做
		// authc：该过滤器下的页面必须验证后才能访问。它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
		Map<String, String> filterChainDefinitionMap = UrlConstantsConfig.ANON_MAP;
/*		filterChainDefinitionMap.put(UrlConstantsConfig.LOGIN_CHECK_URL, "login_authc");// 登录请求
		filterChainDefinitionMap.put("/**", "authc");*/
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;
	}

	/**
	 * Shiro Realm 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类
	 *
	 * @return
	 */
	@Bean
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		// 告诉realm,使用credentialsMatcher加密算法类来验证密文
		userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		userRealm.setCachingEnabled(false);
		return userRealm;
	}
}
