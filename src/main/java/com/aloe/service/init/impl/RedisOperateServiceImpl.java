package com.aloe.service.init.impl;

import com.aloe.service.redis.IRedisOperateService;
import com.aloe.utils.JSONParserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedisOperateServiceImpl implements IRedisOperateService {
    @Autowired
    private JedisCluster jedisCluster;
    private final String SET_SUCCESS = "OK";

    @Override
    public boolean setString(String key, String value) {
        String set = jedisCluster.set(key, value);
        return SET_SUCCESS.equals(set);
    }

    @Override
    public String getString(String key) {
        String value = jedisCluster.get(key);
        return value;
    }

    @Override
    public boolean delString(String key) {
        Long i = jedisCluster.del(key);
        return i > 0;
    }

    @Override
    public boolean hsetMap(String key, String mapKey, String mapValue) {
        return false;
    }

    @Override
    public String hgetMap(String key, String mapKey) {
        return null;
    }

    /**
     * @param key
     * @param mapValue
     * @param <K>
     * @param <V>
     * @return
     */
    @Override
    public <K, V> boolean hmsetMap(String key, Map<K, V> mapValue) {
        if (StringUtils.isNotBlank(key) && mapValue != null && !mapValue.isEmpty()) {
            Map<byte[], byte[]> map = new HashMap<>();
            for (Map.Entry m : mapValue.entrySet()) {
                map.put(m.getKey().toString().getBytes(), JSONParserUtil.toJSONString(m.getValue()).getBytes());
            }
            String hmset = jedisCluster.hmset(key.getBytes(), map);
            return SET_SUCCESS.equals(hmset);
        }
        return false;
    }

    @Override
    public <K, V> Map<K, V> hmgetMap(String key) {
        return null;
    }

    @Override
    public  Map<String, String> hgetAllMap(String key) {
        return jedisCluster.hgetAll(key);
    }

    @Override
    public boolean hdelMap(String key) {
        return false;
    }
}
