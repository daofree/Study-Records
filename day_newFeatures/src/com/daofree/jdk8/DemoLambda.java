package com.daofree.jdk8;

/**
 * @ClassName DemoLambda
 * @Description: 无参无返回值
 * @Author DaoTianXia
 * @Date 2020-07-25-23:20
 * @Version V1.0
 **/
public class DemoLambda {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("匿名内部类来做饭了");
            }
        });

        invokeCook(()->{
            System.out.println("lambda 来做饭了");
        });

        // 更省略--泛型推断
        invokeCook(()-> System.out.println("lambda 来做饭了"));
    }
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
@FunctionalInterface
interface Cook{
    void makeFood();
}