package com.daofree.jdk5;

import com.daofree.testenum.Direcation;

/**
 * @ClassName MyAnno
 * @Description: 自定义注解
 * @Author DaoTianXia
 * @Date 2020-08-16-18:29
 * @Version V1.0
 **/
public @interface MyAnno {
    String name() default "mingping";
    int age() default 28;
    Direcation show3() default Direcation.FRONT;
    int[] show4() default {1,2};
    MyAnno2 show5() default @MyAnno2;

}
