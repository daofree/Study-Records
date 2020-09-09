package com.daofree.jdk5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MyAnno
 * @Description: 自定义注解2
 * @Author DaoTianXia
 * @Date 2020-08-16-18:29
 * @Version V1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno2 {
    String className() default "aaa";
    String methodName() default "bb";
}
