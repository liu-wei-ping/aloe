/**
 * lwp
 * 2017年8月6日
 */
package com.aloe.controller.login;

import com.aloe.constants.UrlContstantsConfig;
import com.aloe.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lwp 2017年8月6日
 */
@Controller
public class IndexController extends BaseController {
	/**
	 * 默认页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlContstantsConfig.DEFAULT_VISIT_URL, method = RequestMethod.GET)
	public String defaultIndex(Model model) {
		String userName = String.valueOf(SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("username", userName);
		return UrlContstantsConfig.DEFAULT_VISIT_PAGE;
	}

	/**
	 * 登录成功页面
	 *
	 * @param model
	 * @return
	 */
	/* @RequiresRoles("ADMIN") */
	@RequestMapping(value = UrlContstantsConfig.LOGIN_SUCCESS_URL, method = RequestMethod.GET)
	public String index(Model model) {
		String username = String.valueOf(SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("username", username);
		return UrlContstantsConfig.LOGIN_SUCCESS_PAGE;
	}
}
