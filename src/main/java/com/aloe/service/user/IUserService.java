package com.aloe.service.user;

import java.util.List;
import java.util.Set;

import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.RightInfoVo;
import com.aloe.pojo.vo.RoleInfoVo;
import com.aloe.pojo.vo.UserInfoVo;

/**
 * 用户信息API
 *
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
public interface IUserService {
	/**
	 * 修改用户密码
	 *
	 * @param userInfoVo
	 * @param newPassword
	 * @return
	 */
	ResponseResultVo changeUserPassword(UserInfoVo userInfoVo, String newPassword);

	/**
	 * 添加用户-角色关联
	 *
	 * @param userInfoVo
	 * @param roleInfoVoSets
	 * @return
	 */
	ResponseResultVo correlationRoles(UserInfoVo userInfoVo, Set<RoleInfoVo> roleInfoVoSets);

	/**
	 * 用户新增
	 *
	 * @param userInfoVo
	 * @return
	 */
	ResponseResultVo createUserInfo(UserInfoVo userInfoVo);

	/**
	 * 根据用户信息查询权限
	 * 
	 * @param userInfoVo
	 * @return
	 */
	List<RightInfoVo> getRightByUser(UserInfoVo userInfoVo);

	/**
	 * 根据用户信息查询权限
	 *
	 * @param userInfoVo
	 * @return
	 */
	List<RightInfoVo> getRightInfoByUser(UserInfoVo userInfoVo);

	/**
	 * 根据用户信息查找角色信息
	 *
	 * @param userInfoVo
	 * @return
	 */
	List<RoleInfoVo> getRoleInfoByUser(UserInfoVo userInfoVo);

	/**
	 * 根据用户名称获取用户信息
	 *
	 * @param userName
	 * @return
	 */
	UserInfoVo getUserInfoByName(String userName);

	/**
	 * 移除用户-角色关联
	 *
	 * @param userInfoVo
	 * @param roleInfoVoSets
	 * @return
	 */
	ResponseResultVo uncorrelationRoles(UserInfoVo userInfoVo, Set<RoleInfoVo> roleInfoVoSets);

	/**
	 * 更新用户信息
	 *
	 * @param userInfoVo
	 * @return
	 */
	ResponseResultVo updateUserInfo(UserInfoVo userInfoVo);
}
