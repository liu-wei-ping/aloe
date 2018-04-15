package com.aloe.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * JSON 工具类
 *
 */
public class JSONParserUtil {

    /**
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * @param object
     * @param datePattern
     * @return
     */
    public static String toJSONString(Object object, String datePattern) {
        return JSON.toJSONStringWithDateFormat(object, datePattern);
    }

    /**
     * @param jsonStr
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> toMapOfJSONString(String jsonStr) {
        return JSON.parseObject(jsonStr, Map.class);
    }

    /**
     * @param jsonStr
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T toObjectOfJSONString(String jsonStr, Class<T> tClass) {
        return JSON.parseObject(jsonStr, tClass);
    }

    /**
     * @param jsonStr
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<T> toArrayOfJSONString(String jsonStr, Class<T> tClass) {
        return JSON.parseArray(jsonStr, tClass);
    }
}
