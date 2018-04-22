package com.aloe.service.init.impl;

import com.aloe.mapper.RoleRightRelationEntiryMapper;
import com.aloe.mapper.UserInfoEntiryMapper;
import com.aloe.pojo.entity.UserInfoEntity;
import com.aloe.service.init.IInitService;
import com.aloe.service.redis.IRedisOperateService;
import com.aloe.utils.JSONParserUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化缓存 服务
 */
@Service
public class InitServiceImpl implements IInitService {
    @Autowired
    private UserInfoEntiryMapper userInfoEntiryMapper;
    @Autowired
    private RoleRightRelationEntiryMapper roleRightRelationEntiryMapper;
    @Autowired
    private IRedisOperateService iRedisOperateService;

    /**
     * 初始化 用户缓存
     *
     * @return
     */
    @Override
    public String initUserToRedis() {
        Example example = new Example(UserInfoEntity.class);
        example.createCriteria().andEqualTo("status", 0);
        List<UserInfoEntity> userInfoEntities = userInfoEntiryMapper.selectByExample(example);
        Map<String,UserInfoEntity> mapRedis=new HashMap<>();
        if (!CollectionUtils.isEmpty(userInfoEntities)) {
            for (UserInfoEntity entity : userInfoEntities) {
                mapRedis.put(entity.getUserNo(),entity);
            }
        }
//        Map<Object, Object> objectObjectMap = JSONParserUtil.toMapOfJSONString(JSONParserUtil.toJSONString(userInfoEntities));
        boolean flag = iRedisOperateService.hmsetMap("login_user", mapRedis);
        iRedisOperateService.setString("hello", "你好！");
        String hello = iRedisOperateService.getString("hello");
        Map<String, String> objectObjectMap1 = iRedisOperateService.hgetAllMap("login_user");
        System.out.println(hello);
        return JSONParserUtil.toJSONString(objectObjectMap1);
    }

    /**
     * 初始化用户 权限缓存
     *
     * @return
     */
    @Override
    public boolean initRightToRedis() {
        return false;
    }
}
