package com.daofree.entity;

/**
 * @ClassName LvShi
 * @Description: 给其他模块使用
 * @Author DaoTianXia
 * @Date 2020-09-21-9:22
 * @Version V1.0
 **/
public class LvShi {
    private String name;

    public LvShi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void study(){
        System.out.println("JDK9新特性，模块化使用-普通方法");
    }
    public static void suSong(){
        System.out.println("JDK9新特性，模块化使用-静态方法");
    }
}
