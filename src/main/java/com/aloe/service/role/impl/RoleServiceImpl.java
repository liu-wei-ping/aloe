package com.aloe.service.role.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloe.mapper.RoleInfoEntiryMapper;
import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.RightInfoVo;
import com.aloe.pojo.vo.RoleInfoVo;
import com.aloe.service.BaseService;
import com.aloe.service.role.IRoleService;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
@Service
public class RoleServiceImpl extends BaseService implements IRoleService {
	@Autowired
	private RoleInfoEntiryMapper mapper;

	@Override
	public ResponseResultVo correlationRights(RoleInfoVo roleInfoVo, Set<RightInfoVo> rightSets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResultVo createRoleInfo(RoleInfoVo roleInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RightInfoVo> getRightInfoByRole(RoleInfoVo roleInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResultVo uncorrelationRights(RoleInfoVo roleInfoVo, Set<RightInfoVo> rightSets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResultVo updateRoleInfo(RoleInfoVo roleInfoVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
