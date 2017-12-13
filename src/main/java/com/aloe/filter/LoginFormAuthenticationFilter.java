package com.aloe.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aloe.constants.UrlContstantsConfig;

/**
 * 登录操作
 *
 * @author liu_wp
 * @date 2017年10月13日
 * @see
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
	private final Logger logger = LoggerFactory.getLogger(LoginFormAuthenticationFilter.class);

	@Override
	public String getLoginUrl() {
		return UrlContstantsConfig.LOGIN_CHECK_URL;
	}

	/**
	 * 用户密码Key 默认是：password
	 *
	 * @return
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#getPasswordParam()
	 */
	@Override
	public String getPasswordParam() {
		// TODO Auto-generated method stub
		return "loginPwd";
	}

	/**
	 * 记住我 Key 默认是：rememberMe
	 *
	 * @return
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#getRememberMeParam()
	 */
	@Override
	public String getRememberMeParam() {
		// TODO Auto-generated method stub
		return super.getRememberMeParam();
	}

	@Override
	public String getSuccessUrl() {
		// TODO Auto-generated method stub
		return super.getSuccessUrl();
	}

	/**
	 * 用户名称Key 默认 是 username
	 *
	 * @return
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#getUsernameParam()
	 */
	@Override
	public String getUsernameParam() {
		return "userName";
	}

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		return super.executeLogin(request, response);
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.issueSuccessRedirect(request, response);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		logger.info("登录表单校验....");
		// TODO 在这里进行验证码的校验
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}
}
