package com.daofree.jdk8.function;

import java.util.function.Predicate;

/**
 * @ClassName Predi
 * @Description: 判断某种数据类型
 * @Author DaoTianXia
 * @Date 2020-09-19-17:10
 * @Version V1.0
 **/
public class Predi {
    public static void main(String[] args) {
        String s = "daofree";
        Boolean aBoolean = testPredi(s, (st) -> {
            return s.length() > 5;
        });

        // 更省略
        Boolean aB = testPredi(s, (st) -> s.length() > 5);
        System.out.println(aBoolean);

        // 这时什么写法？？参考上面，实现了test方法
        testP(s1->s1.length() > 5);

        // 默认方法与或非 and or negate  省略了return
        boolean b = checkString("6e6q", (s2) -> s2.length() > 5);
        System.out.println("默认方法" + b);
    }

    public static Boolean testPredi(String name, Predicate<String> p){
        return p.test(name);
    }

    public static void testP(Predicate<String> p){
        boolean hello = p.test("hello");
        System.out.println("这时什么操作" + hello);
    }

    /**
     * Check string boolean.
     *          默认逻辑方法，非negate
     * @param s   the s
     * @param pre the pre
     * @return the boolean
     */
    public static boolean checkString(String s, Predicate<String> pre){
        //return !pre.test(s);
        return pre.negate().test(s);
    }
}
