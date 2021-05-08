package com.daily.verify.verify.bean.util;

import com.alibaba.excel.util.StringUtils;
import com.daily.verify.verify.exception.RegularException;

import java.lang.reflect.Field;

/**
 * 反射工具类
 */
public class GenericReflexUtils {
    //获取对象指定字段的值
    public static Object getValue(Object object, String filedName) {
        rule(object, filedName);
        Object result = null;
        try {
            Field field = object.getClass().getDeclaredField(filedName);
            field.setAccessible(true);
            result = field.get(object);
        } catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
            throw new RegularException("10001", noSuchFieldException.getMessage(), "");
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            throw new RegularException("10001", illegalAccessException.getMessage(), "");
        }
        return result;
    }

    //给指定对象指定字段赋值
    public static void setValue(Object target, String filedName, Object value) {
        rule(target, filedName, value);
        try {
            Field field = target.getClass().getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
            throw new RegularException("10001", noSuchFieldException.getMessage(), "");
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            throw new RegularException("10001", illegalAccessException.getMessage(), "");
        }
    }

    private static void rule(Object target, String filedName, Object value) {
        if (null == target)
            throw new RegularException("70001", "入参对象为null", "入参变量 target");
        if (StringUtils.isEmpty(filedName))
            throw new RegularException("70001", "入参对象为null", "入参变量 filedName");
        if (null == value)
            throw new RegularException("70001", "入参对象为null", "入参变量 value");
    }


    private static void rule(Object object, String filedName) {
        rule(object, filedName, new Object());
    }
}
