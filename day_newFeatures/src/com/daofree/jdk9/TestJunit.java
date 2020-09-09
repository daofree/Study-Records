package com.daofree.jdk9;

import org.junit.Test;

import java.util.Date;

/**
 * @ClassName TestJunit
 * @Description: 单元测试
 * @Author DaoTianXia
 * @Date 2020-07-29-23:52
 * @Version V1.0
 **/
@SuppressWarnings("all")
public class TestJunit {

    @Test
    public void testAdd(){
        System.out.println("-------");
    }


    @Test
    public void test36(){
        String string = Long.toString(new Date().getTime());
        String string2 = Long.toString(new Date().getTime(),36);
        // 1596122027922 1596122540605
        System.out.println(string);
        // kd8xuetu kd8y5ef1
        System.out.println(string2);
        System.out.println("---------------");
        long a = System.currentTimeMillis();
        long b = new Date().getTime();
        System.out.println(a);
        System.out.println(b);

    }
}
