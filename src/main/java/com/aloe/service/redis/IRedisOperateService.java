package com.aloe.service.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRedisOperateService {
    /**  设置String 值
     * @param key
     * @param value
     * @return
     */
    boolean setString(String key,String value);

    /**  获取String 值
     * @param key
     * @return
     */
    String getString(String key);

    /** 删除String 值
     * @param key
     * @return
     */
    boolean delString(String key);

    /** 设置 map 值  一个
     * @param key
     * @return
     */
    boolean hsetMap(String key,String mapKey,String mapValue);

    /**
     * @param key
     * @param mapKey
     * @return
     */
    String  hgetMap(String key,String mapKey);

    /**
     * @param key
     * @param mapValue
     * @param <K>
     * @param <V>
     * @return
     */
    <K,V> boolean hmsetMap(String key,Map<K,V> mapValue);

    /**
     * @param key
     * @param <K>
     * @param <V>
     * @return
     */
    <K,V> Map<K,V> hmgetMap(String key);

    /**
     * @param key
     * @return
     */
     Map<String,String > hgetAllMap(String key);

    /**
     * @param key
     * @return
     */
    boolean hdelMap(String key);

//    boolean lpushList(String key,List<String> listValue);
//    String rpopList(String key);
//    List<String> lrangeList(String key,int start,int end);
//    Long llenList(String key);
//    boolean lremList(String key,int index,String delValue);

//    boolean zaddSet(String key,Map<String ,String> mapValue);
//    Set<String> zrangeSet(String key,int start,int end);
//    Set<String> zrevrangeWithScoresSet(String key,int start,int end);
//    Long zcardSet(String key);
//    boolean zremSet(String parentKey,String subKey);
}
