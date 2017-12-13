package com.aloe.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author liu_wp
 * @date 2017年9月30日
 * @see
 */
public class HttpRequestContext extends HttpServletRequestWrapper {

	public HttpRequestContext(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

}
