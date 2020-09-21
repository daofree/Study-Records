package com.daofree.jdk8;

/**
 * @ClassName MethodUseDemo
 * @Description: 方法引用
 * @Author DaoTianXia
 * @Date 2020-09-20-10:44
 * @Version V1.0
 **/
public class MethodUseDemo {
    public static void main(String[] args) {
        // lambda拿到参数，传递给方法体
        printString("daofree", (s)-> System.out.println(s));
        // 直接取代lambda，方法引用，更简洁
        printString("daofree", System.out::println);

    }

    public static void printString(String s,Printable p){
        p.print(s);
    }

}


@FunctionalInterface
interface Printable{
    void print(String s);
}
