package com.aloe.controller.setting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloe.controller.BaseController;

/**
 * @author liu_wp
 * @date 2017年11月1日
 * @see
 */
@Controller
@RequestMapping("/setting")
public class UserSettingController extends BaseController {

	/**
	 * @return
	 */
	@GetMapping(value = "/user")
	public String userSetting() {
		return "user";
	}
}
