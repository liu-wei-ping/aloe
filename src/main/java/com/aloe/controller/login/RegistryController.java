package com.aloe.controller.login;

import com.aloe.constants.SysConstantsConfig;
import com.aloe.constants.UrlContstantsConfig;
import com.aloe.controller.BaseController;
import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.UserInfoVo;
import com.aloe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = UrlContstantsConfig.REGISTER_URL, method = RequestMethod.GET)
    public String register() {
        return UrlContstantsConfig.REGISTER_PAGE;
    }

    /**
     * 注册
     *
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = UrlContstantsConfig.REGISTER_CHECK_URL, method = RequestMethod.POST)
    public String register(UserInfoVo user, Model model) {
        ResponseResultVo result = iUserService.createUserInfo(user);
        if (result.getCode().equals(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE)) {
            return UrlContstantsConfig.REGISTER_TRANSFER_PAGE;
        }
        model.addAllAttributes(ResponseResultVo.returnPgeResultMap(result));
        return UrlContstantsConfig.REGISTER_PAGE;
    }
}
