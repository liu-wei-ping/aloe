package com.aloe.utils;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.ArrayUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 对象转换工具类
 *
 * @author liu wp
 * @date 2017年9月27日
 */
public class DozerMapperUtil {
    private final static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    /**
     * 日志对象
     **/
    private static final Logger logger = LoggerFactory.getLogger(DozerMapperUtil.class);

    /**
     * @param source
     * @param destination
     */
    public static void copy(Object source, Object destination) {
        dozerBeanMapper.map(source, destination);
    }

    /**
     * 对象映射
     *
     * @param source
     * @param destinationClass
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozerBeanMapper.map(source, destinationClass);
    }

    /**
     * 集合映射成List
     *
     * @param sourceList
     * @param destinationClass
     * @return
     */
    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        final List<T> tagaList = new ArrayList<T>();
        for (Object object : sourceList) {
            tagaList.add(dozerBeanMapper.map(object, destinationClass));
        }
        return tagaList;
    }

    /**
     * 将目标对象的所有属性转换成Map对象
     *
     * @param target           目标对象
     * @param ignoreParent     是否忽略父类的属性
     * @param ignoreEmptyValue 是否不把空值添加到Map中
     * @param ignoreProperties 不需要添加到Map的属性名
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> toMap(Object target, boolean ignoreParent, boolean ignoreEmptyValue,
                                           String... ignoreProperties) {
        Map<String, T> map = new HashMap<String, T>();

        List<Field> fields = ReflectionUtil.getAccessibleFields(target.getClass(), ignoreParent);

        for (Iterator<Field> it = fields.iterator(); it.hasNext(); ) {
            Field field = it.next();
            T value = null;

            try {
                value = (T) field.get(target);
            } catch (Exception e) {
                String errormsg = ExceptionUtil.getStackTrace(e);
                logger.error("获取属性【{}】值错误【{}】", field.getName(), errormsg);

            }

            if (ignoreEmptyValue && ((value == null || StringUtils.EMPTY.equals(value.toString()))
                    || (value instanceof Collection && ((Collection<?>) value).isEmpty())
                    || (value instanceof Map && ((Map<?, ?>) value).isEmpty()))) {
                continue;
            }

            String key = field.getName();
            boolean flag = ArrayUtils.contains(ignoreProperties, key);
            if (!flag) {
                map.put(key, value);
            }
        }

        return map;
    }
}
