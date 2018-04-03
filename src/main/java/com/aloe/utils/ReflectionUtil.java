package com.aloe.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * @author liu wp
 * @date 2017年9月27日
 */
public class ReflectionUtil {
    /**
     * 获取对象Field
     *
     * @param clazz
     * @param ignoreParent 是否忽略父类
     * @return
     */
    public static List<Field> getAccessibleFields(Class<?> clazz, boolean ignoreParent) {
        List<Field> fieldList = new ArrayList<Field>();
        do {
            final Field[] fields = clazz.getDeclaredFields();
            for (final Field field : fields) {
                field.setAccessible(true);
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    fieldList.add(field);
                }
            }
            clazz = clazz.getSuperclass();
        } while ((clazz != Object.class) && ignoreParent);
        return fieldList;
    }

    // public static void main(String[] args) {
    // List<Field> fieldList =
    // ReflectionUtil.getAccessibleFields(UserInfoVo.class, true);
    // for (Field field : fieldList) {
    // System.out.println(field.getName());
    // }
    // }
}
