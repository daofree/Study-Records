package com.daofree.jdk8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName DemoLambda2
 * @Description: 有参数有返回值
 * @Author DaoTianXia
 * @Date 2020-09-18-11:16
 * @Version V1.0
 **/
public class DemoLambda2 {
    public static void main(String[] args) {
        Person[] p = {
                new Person("深田咏美",25),
                new Person("三上悠亚",23),
                new Person("佐佐木明希",24)
        };

        // 匿名内部类--对象数组 + 比较器（升序-->前-后）
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for (Person pp :p) {
            System.out.println(pp);
        }
        System.out.println("----------lambda----------");
        // lambda 表达式
        Arrays.sort(p,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        for (Person pp :p) {
            System.out.println("lambda1 =="+ pp);
        }

        System.out.println("=========================");
        // 更加简化
        Arrays.sort(p, Comparator.comparingInt(Person :: getAge));
        for (Person pp : p) {
            System.out.println("lambda2 =="+ pp);
        }

        // lambda要有上下文可推导，不可独立存在
        Runnable r = () -> System.out.println("...");
    }
}
