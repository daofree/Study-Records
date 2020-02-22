package cn.daofree.reflect;

import cn.daofree.domian.Person;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectDemo4
 * @Description: 3. 获取成员方法们
 * @Author DaoTianXia
 * @Date 2020-02-22-21:47
 * @Version V1.0
 **/
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        //* Method getMethod(String name, 类<?>... parameterTypes)
        // 方法三要素：方法名，返回值，参数列表
        // 确定一个方法，方法名，参数列表
        Method eat_Method = personClass.getMethod("eat");
        Person person = new Person();
        // 执行方法
        eat_Method.invoke(person);

        Method eat_Method2 = personClass.getMethod("eat",String.class);
        eat_Method2.invoke(person,"饭");

        System.out.println("===============");
        // 获取所有怕public的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }

        System.out.println("###########################");
        String classname = personClass.getName();
        System.out.println(classname);
        //cn.daofree.domian.Person
    }
}
