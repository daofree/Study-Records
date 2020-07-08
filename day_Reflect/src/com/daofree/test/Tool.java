package com.daofree.test;

import java.lang.reflect.Field;

/**
 * @ClassName Tool
 * @Description: setProperty(对象obj, 属性名, 设值value);
 * @Author DaoTianXia
 * @Date 2020-07-08-23:37
 * @Version V1.0
 **/
public class Tool {
    public void setProperty(Object o, String name, Object value)
            throws NoSuchFieldException, IllegalAccessException {

        Class<?> aClass = o.getClass();
        Field f = aClass.getDeclaredField(name);
        f.setAccessible(true);
        f.set(o, value);
    }
}
