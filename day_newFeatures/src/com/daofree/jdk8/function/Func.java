package com.daofree.jdk8.function;

import java.util.function.Function;

/**
 * @ClassName Func
 * @Description: 转换型函数接口
 * @Author DaoTianXia
 * @Date 2020-09-19-21:41
 * @Version V1.0
 **/
public class Func {
    public static void main(String[] args) {
        change("123", s -> Integer.parseInt(s) + 1, i -> i+"", s-> s+ "sange");
    }


    /**
     * Change.
     *      默认组合方法 andThen
     *      核心方法apply()
     * @param s    the s
     * @param fun1 the fun 1
     * @param fun2 the fun 2
     */
    public static void change(String s, Function<String, Integer> fun1,
                              Function<Integer, String> fun2,
                              Function<String, String> fun3){
        String a = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(a);
    }
}
