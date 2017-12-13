package com.aloe.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aloe.constants.SysConstantsConfig;

/**
 * 获取Request 信息工具类。<br>
 * 列如：IP地址，访问渠道..
 *
 * @author liu_wp
 * @date 2017年10月11日
 * @see
 */
public class HttpRequestUtil {

	/**
	 * 浏览器Agent代理标识
	 */
	public final static String[] mobileAgents = { "iphone", "android", "ipad", "phone", "mobile", "wap", "netfront",
			"java", "opera mobi", "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony",
			"blackberry", "dopod", "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc",
			"motorola", "foma", "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra",
			"coolpad", "webos", "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips",
			"sagem", "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
			"pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320", "240x320",
			"176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew",
			"cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi", "keji",
			"leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-", "moto",
			"mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap",
			"sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar",
			"sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-",
			"wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-", "Googlebot-Mobile" };

	/**
	 * 判断手机还是电脑浏览器
	 *
	 * @param String
	 *            userAgentInfo
	 * @return boolean false：电脑 true：手机
	 */
	public static boolean checkAgentIsMobile(String userAgentInfo) {
		// 标识位
		boolean isMoblie = false;
		// 判断是否为空
		if (StringUtils.isBlank(userAgentInfo)) {
			return isMoblie;
		}
		userAgentInfo = userAgentInfo.toLowerCase();
		// 判断移动浏览器
		for (String mobileAgent : mobileAgents) {
			if (userAgentInfo.indexOf(mobileAgent) >= 0 && userAgentInfo.indexOf("windows nt") <= 0
					&& userAgentInfo.indexOf("macintosh") <= 0) {
				isMoblie = true;
				break;
			}
		}
		return isMoblie;
	}

	/**
	 * 获取访问渠道类型。
	 *
	 * @return
	 */
	public static String getChannelByRequest() {
		HttpServletRequest request = getHttpServletRequest();
		return getChannelByRequest(request);
	}

	/**
	 * 获取访问渠道类型【PC,mobile,weiXin】 根据HttpServletRequest。
	 *
	 * @param request
	 * @return
	 */
	public static String getChannelByRequest(HttpServletRequest request) {
		return getChannelByUserAgent(getUserAgentInfo(request));
	}

	/**
	 * 获取访问渠道类型【PC,mobile,weiXin】，根据UA。
	 *
	 * @param String
	 *            userAgentInfo
	 * @return String
	 */
	public static String getChannelByUserAgent(String userAgentInfo) {
		if (!checkAgentIsMobile(userAgentInfo)) {
			// PC浏览器渠道
			return SysConstantsConfig.REG_SOURCE_PC;
		} else {
			if (isWeChat(userAgentInfo)) {
				// 微信渠道
				return SysConstantsConfig.REG_SOURCE_WX;
			} else {
				// 移动浏览器渠道
				return SysConstantsConfig.REG_SOURCE_MOBILE;
			}
		}
	}

	/**
	 * 获取当前 HttpServletRequest 对象
	 *
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return servletRequestAttributes.getRequest();
	}

	/**
	 * 多次反向代理后会有多个ip值，第一个ip才是真实ip
	 *
	 * @param request
	 * @return String
	 */
	public static String getIp2(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	/**
	 * 获取用户访问IP地址
	 *
	 * @return
	 */
	public static String getRemoteIp() {
		HttpServletRequest request = getHttpServletRequest();
		return getRemoteIp(request);
	}

	/**
	 * 获取用户访问IP地址
	 *
	 * @param request
	 * @return String
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip1 = request.getRemoteAddr();
		String ip2 = getIp2(request);
		String value = (ip1.equals(ip2)) ? ip1 : ip1 + " | " + ip2;
		return StringUtils.trimToEmpty(value);
	}

	/**
	 * 获取 请求路径
	 * 
	 * @return
	 */
	public static String getRequestUrl() {
		HttpServletRequest request = getHttpServletRequest();
		final String requestUrl = request.getRequestURI().toString();
		return requestUrl;
	}

	/**
	 * 获取用户UA
	 *
	 * @param request
	 * @return String
	 */
	public static String getUserAgentInfo(HttpServletRequest request) {
		String value = request.getHeader("user-agent");
		return StringUtils.trimToEmpty(value);
	}

	/**
	 * 判断是否是微信访问
	 *
	 * @param String
	 *            userAgentInfo
	 * @return boolean false：不是微信 true：是微信
	 */
	public static boolean isWeChat(String userAgentInfo) {
		userAgentInfo = userAgentInfo.toLowerCase();
		return userAgentInfo == null || userAgentInfo.indexOf("micromessenger") == -1 ? false : true;
	}
}
