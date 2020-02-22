package cn.daofree.reflect;

import cn.daofree.domian.Person;

import java.lang.reflect.Constructor;

/**
 * @ClassName ReflectDemo3
 * @Description: 2. 获取构造方法们Constructor<?>[]
 * @Author DaoTianXia
 * @Date 2020-02-22-21:26
 * @Version V1.0
 **/
public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;
        // Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 创建对象
        Object person = constructor.newInstance("zhangsan", 35);
        System.out.println(person);

        System.out.println("====================");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor);
        // 创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);

    }
}
