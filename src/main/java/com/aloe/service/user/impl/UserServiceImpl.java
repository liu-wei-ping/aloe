package com.aloe.service.user.impl;

import java.util.List;
import java.util.Set;

import com.aloe.utils.GenerateUniqueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloe.mapper.UserInfoEntiryMapper;
import com.aloe.pojo.entity.UserInfoEntity;
import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.pojo.vo.RightInfoVo;
import com.aloe.pojo.vo.RoleInfoVo;
import com.aloe.pojo.vo.UserInfoVo;
import com.aloe.service.BaseService;
import com.aloe.service.user.IUserService;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {
    @Autowired
    private UserInfoEntiryMapper userInfoEntiryMapper;

    @Override
    public ResponseResultVo changeUserPassword(UserInfoVo userInfoVo, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseResultVo correlationRoles(UserInfoVo userInfoVo, Set<RoleInfoVo> roleInfoVoSets) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseResultVo createUserInfo(UserInfoVo userInfoVo) {
        if (null == userInfoVo) {
            return ResponseResultVo.generateFailedObject("不存在用户信息", userInfoVo);
        }
        userInfoVo.setId(GenerateUniqueUtil.getSid());
        userInfoVo.setUserNo(GenerateUniqueUtil.generateNumber());
        userInfoVo.setLoginPwd(encryptPwd(userInfoVo.getLoginPwd()));
        userInfoVo.setRegSource(getRegRource());
        UserInfoEntity userInfoEntiry = map(userInfoVo, UserInfoEntity.class);
        int count = userInfoEntiryMapper.insertSelective(userInfoEntiry);
        if (count > 0) {
            return ResponseResultVo.generateSuccessObject(null);
        }
        return ResponseResultVo.generateFailedObject("注册失败", userInfoVo);
    }

    @Override
    public List<RightInfoVo> getRightByUser(UserInfoVo userInfoVo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RightInfoVo> getRightInfoByUser(UserInfoVo userInfoVo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoleInfoVo> getRoleInfoByUser(UserInfoVo userInfoVo) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param userName
     * @return
     * @see com.aloe.service.user.IUserService#getUserInfoByName(java.lang.String)
     */
    @Override
    public UserInfoVo getUserInfoByName(String userName) {
        UserInfoEntity userEntiry = userInfoEntiryMapper.selectUserInfoByUserName(userName);
        UserInfoVo userInfoVo = null;
        if (null != userEntiry) {
            userInfoVo = map(userEntiry, UserInfoVo.class);
        }
        return userInfoVo;
    }

    @Override
    public ResponseResultVo uncorrelationRoles(UserInfoVo userInfoVo, Set<RoleInfoVo> roleInfoVoSets) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseResultVo updateUserInfo(UserInfoVo userInfoVo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserInfoVo> finidAllUser() {
        List<UserInfoEntity> userInfoEntities = userInfoEntiryMapper.selectAll();
        return mapToList(userInfoEntities, UserInfoVo.class);
    }

}
