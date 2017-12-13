/**
 * lwp
 * 2017年8月6日
 */
package com.aloe.controller.login;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloe.controller.BaseController;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultIndex(Model model) {
		String userName = String.valueOf(SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("username", userName);
		return "index";
	}

	/**
	 * 登录成功页面
	 *
	 * @param model
	 * @return
	 */
	/* @RequiresRoles("ADMIN") */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		String username = String.valueOf(SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("username", username);
		return "index";
	}
}
