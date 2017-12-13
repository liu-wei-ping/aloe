package com.aloe.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloe.constants.SysConstantsConfig;
import com.aloe.controller.BaseController;
import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.UserInfoVo;
import com.aloe.service.user.IUserService;

/**
 * @author liu_wp
 * @date 2017年10月10日
 * @see
 */
@Controller
public class RegistryController extends BaseController {

	@Autowired
	private IUserService iUserService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/checkregister", method = RequestMethod.POST)
	public String register(UserInfoVo user, Model model) {
		ResponseResultVo result = iUserService.createUserInfo(user);
		if (result.getCode().equals(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE)) {
			return "jump";
		}
		model.addAllAttributes(ResponseResultVo.returnPgeResultMap(result));
		return "register";
	}
}
