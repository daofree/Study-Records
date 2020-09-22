package com.daofree.jdk8.time;

import org.junit.Test;

import java.time.*;

/**
 * @ClassName TimeDemo
 * @Description: JDK8的时间
 * @Author DaoTianXia
 * @Date 2020-09-21-16:02
 * @Version V1.0
 **/
public class TimeDemo {
    @Test
    public void test1(){
        LocalDate now = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(now, localTime);
        System.out.println(now);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("-------指定日期of-------");
        // 没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 10, 6, 16, 15);

        System.out.println("------get--------");
        // get方法
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());

        System.out.println("---------设置属性-with----------");
        System.out.println("------体现不可变形---不是同一个对象了-----");
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(28);
        // 2020-09-21T16:14:27.649349900
        System.out.println(localDateTime);
        // 2020-09-28T16:14:27.649349900
        System.out.println(localDateTime1);

        System.out.println("-------添加plus------");
        LocalDateTime localDateTime2 = localDateTime.plusDays(1);
        System.out.println(localDateTime2);
        System.out.println("------减minus------");
        System.out.println(localDateTime.minusDays(1));

    }

    @Test
    public void testInstant(){
        // 本初子午线的时间, 默认UTC时区
        Instant now = Instant.now();
        System.out.println(now);
        // 添加偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        // 获取毫秒数
        long l = now.toEpochMilli();
        System.out.println(l);

        Instant.ofEpochMilli(1600680006910L);
    }
}
