/**
 * lwp
 * 2017年8月5日
 */
package com.aloe.controller.login;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aloe.controller.BaseController;
import com.aloe.pojo.vo.UserInfoVo;
import com.aloe.utils.HttpRequestUtil;

/**
 * @author lwp 2017年8月5日
 */
@Controller
public class LoginController extends BaseController {
	@RequestMapping(value = "/st", method = RequestMethod.GET)
	public String aa() {
		return "loginT";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String login(RedirectAttributes redirectAttributes) {
		String errorClassName = (String) HttpRequestUtil.getHttpServletRequest()
				.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (UnknownAccountException.class.getName().equals(errorClassName)) {
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		} else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		} else if (LockedAccountException.class.getName().equals(errorClassName)) {
			redirectAttributes.addFlashAttribute("message", "账户已锁定");
		} else if (errorClassName != null) {
			redirectAttributes.addFlashAttribute("message", "未知错误");
		}
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			return "index";
		}
		return "redirect:/login";
	}

	/**
	 * 登录验证
	 *
	 * @param user
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/checklogin2", method = RequestMethod.POST)
	public String login(@Valid UserInfoVo user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		boolean loginFlag = false;
		String username = user.getUserName();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getLoginPwd());
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			logger.info("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
			loginFlag = true;
			logger.info("对用户[" + username + "]进行登录验证..验证通过");
		} catch (UnknownAccountException uae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		} catch (IncorrectCredentialsException ice) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		} catch (LockedAccountException lae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
			redirectAttributes.addFlashAttribute("message", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
			redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		// 验证是否登录成功
		if (loginFlag && currentUser.isAuthenticated()) {
			logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
			// token.setRememberMe(true);
			return "redirect:/index";
		} else {
			token.clear();
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new UserInfoVo());
		return "login";
	}

	/**
	 * 退出登录
	 *
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes redirectAttributes) {
		// 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("message", "您已安全退出");
		return "redirect:/login";
	}

	/**
	 * 用户没有权限
	 *
	 * @return
	 */
	@RequestMapping("/pages/403")
	public String unauthorizedRole() {
		logger.info("------没有权限-------");
		return "pages/403";
	}
}
