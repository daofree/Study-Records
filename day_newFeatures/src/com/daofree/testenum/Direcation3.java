package com.daofree.testenum;

/**
 * @ClassName Direcation
 * @Description: 枚举类--样式3---抽象与匿名内部类
 * @Author DaoTianXia
 * @Date 2020-07-24-22:27
 * @Version V1.0
 **/
public enum Direcation3 {
    // 前
    FRONT("前"){
        @Override
        public void show() {
            System.out.println("调用方法是 前");
        }
    },
    // 后
    BEHIND("后"){
        @Override
        public void show() {
            System.out.println("调用方法是 后");
        }
    },
    // 左
    LEFT("左"){
        @Override
        public void show() {
            System.out.println("调用方法是 左");
        }
    },
    // 右
    RIGHT("右"){
        @Override
        public void show() {
            System.out.println("调用方法是 右");
        }
    };

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    Direcation3(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void show();
}
