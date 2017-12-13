package com.aloe.mapper;

import org.apache.ibatis.annotations.Param;

import com.aloe.pojo.entity.UserInfoEntity;
import com.aloe.utils.BaseMapper;

public interface UserInfoEntiryMapper extends BaseMapper<UserInfoEntity> {
	/**
	 * @param userName
	 * @return
	 */
	UserInfoEntity selectUserInfoByUserName(@Param("userName") String userName);
}