package com.aloe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.aloe.pojo.entity.RoleInfoEntity;
import com.aloe.utils.BaseMapper;

public interface RoleInfoEntiryMapper extends BaseMapper<RoleInfoEntity> {
	/**
	 * @param userNo
	 * @return
	 */
	@Select("select role_no from user_role_relation where user_no=#{userNo}")
	List<String> selectRoleCodeByUserNo(@Param("userNo") String userNo);
}