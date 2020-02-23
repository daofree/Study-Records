package cn.daofree.annotation;


public @interface MyAnno {

     int value();
     String show2();
     // 枚举
     Person per();
     // 注解
     MyAnno2 anno2();
     // 数组
     String[] strs();
//     String name() default "张三";

//     String show2();

//     String[] strs();

//     Person per();
//     MyAnno2 anno2();

//     String[] strs();


}
