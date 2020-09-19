package com.daofree.jdk8.function;

import java.util.function.Supplier;

/**
 * @ClassName Suppli
 * @Description: 内置常用函数式接口
 *              juf.Supplier 生产型接口--自定义生产
 * @Author DaoTianXia
 * @Date 2020-09-19-10:57
 * @Version V1.0
 **/
public class Suppli {
    public static void main(String[] args) {
        // 调用方法发现，方法参数是函数式接口！重写接口方法实现
        String string = getString(() -> {return "ab";});
        String string2 = getString(() -> "cd");
        System.out.println(string);
        System.out.println(string2);

    }

    // Supplier<T>
    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }
}
