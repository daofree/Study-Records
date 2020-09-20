package com.daofree.jdk8;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ClassName StreamDemo
 * @Description: 流--遍历 姓张--3个字
 * @Author DaoTianXia
 * @Date 2020-09-19-22:18
 * @Version V1.0
 **/
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("李四丰");
        list.add("张张");
        list.add("张无忌");
        list.add("王二叔");
        list.add("高圆圆");
        // 把集合转换为流,利用集合中流的方法,方法参数全是函数式接口
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));

        System.out.println("-----匿名内部类写法-----");

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
