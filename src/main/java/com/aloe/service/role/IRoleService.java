package com.aloe.service.role;

import java.util.List;
import java.util.Set;

import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.RightInfoVo;
import com.aloe.pojo.vo.RoleInfoVo;

/**
 * 角色信息API
 * 
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
public interface IRoleService {
	/**
	 * 添加角色-权限关联
	 *
	 * @param roleInfoVo
	 * @param rightSets
	 * @return
	 */
	ResponseResultVo correlationRights(RoleInfoVo roleInfoVo, Set<RightInfoVo> rightSets);

	/**
	 * 新增角色
	 *
	 * @param roleInfoVo
	 * @return
	 */
	ResponseResultVo createRoleInfo(RoleInfoVo roleInfoVo);

	/**
	 * 根据角色信息查询权限
	 *
	 * @param roleInfoVo
	 * @return
	 */
	List<RightInfoVo> getRightInfoByRole(RoleInfoVo roleInfoVo);

	/**
	 * 移除角色-权限关联
	 *
	 * @param roleInfoVo
	 * @param rightSets
	 * @return
	 */
	ResponseResultVo uncorrelationRights(RoleInfoVo roleInfoVo, Set<RightInfoVo> rightSets);

	/**
	 * 更新角色
	 *
	 * @param roleInfoVo
	 * @return
	 */
	ResponseResultVo updateRoleInfo(RoleInfoVo roleInfoVo);
}
