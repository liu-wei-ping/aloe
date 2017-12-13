/**
 * lwp
 * 2017年8月8日
 */
package com.aloe.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwp 2017年8月8日
 */
public class CsrfHeaderFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {
//		final CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//		if (csrf != null) {
//			Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//			final String token = csrf.getToken();
//			if (cookie == null || token != null && !token.equals(cookie.getValue())) {
//				cookie = new Cookie("XSRF-TOKEN", token);
//				cookie.setPath("/");
//				response.addCookie(cookie);
//			}
//		}
		filterChain.doFilter(request, response);

	}
}
