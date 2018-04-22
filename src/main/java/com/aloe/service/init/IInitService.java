package com.aloe.service.init;

public interface IInitService {
    /**
     * 初始化 用户缓存
     *
     * @return
     */
    String initUserToRedis();

    /**
     * 初始化用户 权限缓存
     *
     * @return
     */
    boolean initRightToRedis();
}
