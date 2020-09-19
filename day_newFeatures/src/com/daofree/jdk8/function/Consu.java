package com.daofree.jdk8.function;

import java.util.function.Consumer;

/**
 * The type Consu.
 *
 * @ClassName Consu
 * @Description: Consumer 消费者
 * @Author DaoTianXia
 * @Date 2020 -09-19-15:27
 * @Version V1.0
 */
public class Consu {

    /**
     * Method. Consumer<T t> 消费者--自定义消费（使用）
     *
     * @param name     the name
     * @param consumer the consumer
     */
    public static void method(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    /**
     * Method andthen.
     *          默认方法andThen
     *          Consumer<T> andThen(Consumer<? super T> after) {
     * @param name the name
     * @param con1 the con 1
     * @param con2 the con 2
     */
    public static void methodAndThen(String name, Consumer<String> con1, Consumer<String> con2){
        con1.accept(name);
        con2.accept(name);

        System.out.println("-----------");
        // 等价于
        con1.andThen(con2).accept(name);
    }

    public static void main(String[] args) {
        // accept
        method("https://zmw3.app/",(name)->
            System.out.println(new StringBuffer(name).reverse().toString())
        );

        System.out.println("两个接口来消费");
        methodAndThen("daofree", (t)->{
            System.out.println(t.toUpperCase());
        },(n)->{
            System.out.println(n.toLowerCase());
        });
    }
}
