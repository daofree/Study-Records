package cn.daofree.reflect;

import cn.daofree.domian.Person;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-22-20:14
 * @Version V1.0
 **/
public class ReflectDemo1 {

    /**
     *
     * @Description: 
     *         获取Class对象的方式：
     *             1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     *             2. 类名.class：通过类名的属性class获取
     *             3. 对象.getClass()：getClass()方法在Object类中定义着。
     * @param: [args]
     * @return: void 
     * @Author: daofree
     * @Date: 20:17 2020/2/22
     *
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //  1. Class.forName("全类名")
        Class aClass1 = Class.forName("cn.daofree.domian.Person");
        System.out.println(aClass1);

        //  2. 类名.class
        Class aClass2 = Person.class;
        System.out.println(aClass2);

        // 3. 对象.getClass()
        Person person = new Person();
        Class aClass3 = person.getClass();
        System.out.println(aClass3);

        // 字符串一样，对象是同一个吗？？==比较三个对象的内存地址，地址同，对象同
        System.out.println(aClass1 == aClass2);
        System.out.println(aClass1 == aClass3);
        System.out.println(aClass2 == aClass3);



    }
}
