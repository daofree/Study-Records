package com.daofree.test;

/**
 * @ClassName ToolDemo
 * @Description: 测试Tool
 * @Author DaoTianXia
 * @Date 2020-07-08-23:43
 * @Version V1.0
 **/
public class ToolDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        person.age = 10;
        Tool tool = new Tool();
        tool.setProperty(person, "name","taiji");
        System.out.println(person);
    }
}
class Person{
    private String name;
    public int age;

    @Override
    public String toString() {
        return name + "---" + age;
    }
}