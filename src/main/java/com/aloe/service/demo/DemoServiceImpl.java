package com.aloe.service.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private JedisCluster jedisCluster;
    @Override
    public String findRedis() {
        jedisCluster.set("userName", "hello lwp redis");
        return jedisCluster.get("userName");
    }
}
