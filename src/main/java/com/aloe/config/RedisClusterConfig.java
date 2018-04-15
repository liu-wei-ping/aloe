package com.aloe.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Configuration
//@ConditionalOnClass(RedisClusterConfig.class)
//@EnableConfigurationProperties(RedisClusterProperties.class)
@ConditionalOnClass({JedisCluster.class})
public class RedisClusterConfig {
    @Resource
    private RedisClusterProperties redisClusterProperties;

//    @Bean
//    public JedisCluster redisCluster(){
//
//        Set<HostAndPort> nodes = new HashSet<>();
//        for (String node:redisClusterProperties.getNodes()){
//            String[] parts= StringUtils.split(node,":");
//            Assert.state(parts.length==2, "redis node shoule be defined as 'host:port', not '" + Arrays.toString(parts) + "'");
//            nodes.add(new HostAndPort(parts[0], Integer.valueOf(parts[1])));
//        }
//
//        return new JedisCluster(nodes);
//    }

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.redis.commandTimeout}")
    private int commandTimeout;


    @Bean
    public JedisCluster getJedisCluster() {
        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        // 分割出集群节点
        for (String node : cNodes) {
            String[] hp = node.split(":");
            nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        // 创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes, commandTimeout, jedisPoolConfig);
        return jedisCluster;
    }

}