package com.daofree.jdk8;

import java.util.ArrayList;

/**
 * @ClassName StreamPre
 * @Description: 传统集合数组的弊端--遍历指定集合
 *              1. 张开头
 *              2. 3个字
 * @Author DaoTianXia
 * @Date 2020-09-19-22:23
 * @Version V1.0
 **/
public class StreamPre {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("李四丰");
        list.add("张张");
        list.add("张无忌");
        list.add("王二叔");
        list.add("高圆圆");
        ArrayList<String> list1 = new ArrayList<>();
        for(String s:list){
            if (s.startsWith("张")){
                list1.add(s);
            }
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list1){
            if(s.length() == 3){
                list2.add(s);
            }
        }

        for (String s : list2){
            System.out.println(s);
        }

    }
}
