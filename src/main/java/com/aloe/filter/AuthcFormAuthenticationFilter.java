package com.aloe.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 过滤 所有 authc 路径
 *
 * @author liu_wp
 * @date 2017年10月13日
 * @see
 */
public class AuthcFormAuthenticationFilter extends FormAuthenticationFilter {
	private final Logger logger = LoggerFactory.getLogger(AuthcFormAuthenticationFilter.class);

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		logger.info("authc 过滤....");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		return super.onAccessDenied(request, response);
	}

}
