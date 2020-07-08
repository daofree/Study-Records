package com.daofree.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @ClassName ArrayListReflectDemo
 * @Description: ArrayList<Integer> 添加字符串！跳过泛型约束
 *                  public boolean add(E e) 源码是Object
 * @Author DaoTianXia
 * @Date 2020-07-08-23:28
 * @Version V1.0
 **/
public class ArrayListReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>();

        array.add(10);
        Class<? extends ArrayList> aClass = array.getClass();
        Method add = aClass.getMethod("add", Object.class);
        Object hello = add.invoke(array, "hello");
        System.out.println(hello);
        System.out.println(array);
        // [10, hello]
    }
}
