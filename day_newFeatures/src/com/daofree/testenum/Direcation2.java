package com.daofree.testenum;

/**
 * @ClassName Direcation
 * @Description: 枚举类--样式2
 * @Author DaoTianXia
 * @Date 2020-07-24-22:27
 * @Version V1.0
 **/
public enum Direcation2 {
    // 前
    FRONT("前"),
    // 后
    BEHIND("后"),
    // 左
    LEFT("左"),
    // 右
    RIGHT("右");

    private String name;
    Direcation2(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
