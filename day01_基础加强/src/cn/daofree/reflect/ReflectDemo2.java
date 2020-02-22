package cn.daofree.reflect;

import cn.daofree.domian.Person;

import java.lang.reflect.Field;

/**
 * @ClassName ReflectDemo2
 * @Description: 获取成员变量们Field[],设值获取值
 * @Author DaoTianXia
 * @Date 2020-02-22-20:50
 * @Version V1.0
 **/
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Field[] fields = personClass.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }
        System.out.println("-------------");
        Field a = personClass.getField("a");
        // 获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        // null
        System.out.println(value);
        // 设置a的值
        a.set(p,"张san");
        System.out.println(p);
        // Person{name='null', age=0, a='张san', b='null', c='null', d='null'}
        System.out.println("====================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        // getDeclaredField
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
