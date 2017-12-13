package com.aloe.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aloe.constants.SysConstantsConfig;
import com.aloe.pojo.vo.RightInfoVo;
import com.aloe.pojo.vo.RoleInfoVo;
import com.aloe.pojo.vo.UserInfoVo;
import com.aloe.service.user.IUserService;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
	@Autowired
	private IUserService iUserService;

	@Override
	protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
			throws AuthenticationException {
		super.assertCredentialsMatch(token, info);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		String loginName = (String) authenticationToken.getPrincipal();
		UserInfoVo userInfo = iUserService.getUserInfoByName(loginName);
		if (null == userInfo) {
			logger.error("登录用户【{}】不存在", loginName);
			throw new UnknownAccountException();
		}
		if (SysConstantsConfig.USER_STATUS_LOCKED == userInfo.getStatus()) {
			logger.error("登录用户【{}】已停用", loginName);
			throw new LockedAccountException();
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，
		// 可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo.getUserName(), // 用户名
				userInfo.getLoginPwd(), // 密码
				getName() // realm name
		);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String currentLoginName = (String) principalCollection.getPrimaryPrincipal();
		UserInfoVo userInfo = iUserService.getUserInfoByName(currentLoginName);
		// 用户角色集合
		Set<String> userRoles = new HashSet<String>();
		// 用户权限集合
		Set<String> userRights = new HashSet<String>();
		if (null != userInfo) {
			// String userNo = userInfo.getUserNo();
			List<RoleInfoVo> userRoleList = iUserService.getRoleInfoByUser(userInfo);
			List<RightInfoVo> userRightList = iUserService.getRightByUser(userInfo);
			// 用户角色
			if (CollectionUtils.isNotEmpty(userRoleList)) {
				userRoles = userRoleList.stream().map(RoleInfoVo::getRoleNo).collect(Collectors.toSet());
				// 保存 redis 缓存
			}
			// 用户权限
			if (CollectionUtils.isNotEmpty(userRightList)) {
				userRights = userRightList.stream().map(RightInfoVo::getRightNo).collect(Collectors.toSet());
				// 保存 redis 缓存
			}
		} else {
			logger.error("登录用户【{}】不存在", currentLoginName);
			throw new AuthorizationException();
		}
		SimpleAuthorizationInfo authorizationsInfo = new SimpleAuthorizationInfo();
		authorizationsInfo.addRoles(userRoles);
		authorizationsInfo.addStringPermissions(userRights);
		return authorizationsInfo;
	}

}
