package com.daofree.jdk5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @ClassName TestAnnoDemo
 * @Description: 测试--定义 + 解析--使用注解
 * @Author DaoTianXia
 * @Date 2020-08-16-18:30
 * @Version V1.0
 **/
@MyAnno2(className = "com.daofree.jdk5.Teacher",methodName = "teach")
public class TestAnnoDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;
        int sum = add(a, b, c);
        System.out.println(sum);


        // 解析注解
        // 获取该类字节码对象(method，filed)
        Class<TestAnnoDemo> testAnnoDemoClass = TestAnnoDemo.class;
        // 获取指定注解对象--在内存中生成了一个该注解接口的子类实现对象
        // public static MyAnno2impl extend MyAnno2{
        //     punlic String className(){
        //           return "com.daofree.jdk5.Teacher";
        //     }
        //     punlic String methodName(){
        //           return "teach";
        //     }
        // }
        MyAnno2 annotation = testAnnoDemoClass.getAnnotation(MyAnno2.class);
        // 调用注解对象的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className + "---" + methodName);
        //
        try {
            Class<?> aClass = Class.forName(className);
            Object o = aClass.newInstance();
            Method method = aClass.getMethod(methodName);
            method.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ab1");
        arrayList.add("ab2");
        arrayList.add("ab3");
        arrayList.add("ab4");
        // 增强for
        for(String ch : arrayList){
            System.out.println(ch);
        }
    }

    /**
     * Add int.
     *  可变参数其实就是一个不定长度的数组,
     *  数组长度随传入方法的对应参数个数来决定。
     *  可变参数只能在参数列表的末位使用。
     * @param a the a
     * @return the int
     */
    @MyAnno(name = "zhangsan",age = 32)
    public static int add(int... a){
        int[] b = a;
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += b[i];
        }
        return sum;
    }
}
