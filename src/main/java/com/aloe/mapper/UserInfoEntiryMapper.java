package com.aloe.mapper;

import org.apache.ibatis.annotations.Param;

import com.aloe.pojo.entity.UserInfoEntity;
import com.aloe.utils.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoEntiryMapper extends BaseMapper<UserInfoEntity> {
	/**
	 * @param userName
	 * @return
	 */
	UserInfoEntity selectUserInfoByUserName(@Param("userName") String userName);
}