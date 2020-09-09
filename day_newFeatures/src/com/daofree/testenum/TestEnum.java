package com.daofree.testenum;

/**
 * @ClassName TestEnum
 * @Description: 枚举类测试
 * @Author DaoTianXia
 * @Date 2020-07-24-22:36
 * @Version V1.0
 **/
public class TestEnum {

    public static void main(String[] args) {
        Direcation d = Direcation.FRONT;
        System.out.println(d);
        System.out.println("------2---------");
        Direcation2 d2 = Direcation2.BEHIND;
        System.out.println(d2);
        System.out.println(d2.getName());
        System.out.println("------3---------");
        Direcation3 d3 = Direcation3.LEFT;
        System.out.println(d3);
        System.out.println(d3.getName());
        // 调用方法是 左
        d3.show();
        d3.setName("中");
        System.out.println("-set方法" + d3.getName());
        // 调用方法是 左
        d3.show();


        Direcation3 dd = Direcation3.RIGHT;
        System.out.println("------switch--------");
        switch (dd){
            case FRONT:
                System.out.println("你的方向是 前");
                break;
            case BEHIND:
                System.out.println("你的方向是 后");
                break;
            case LEFT:
                System.out.println("你的方向是 左");
                break;
            case RIGHT:
                System.out.println("你的方向是 右");
                break;
        }

        System.out.println("----------常用方法-------");
        Direcation df = Direcation.FRONT;
        Direcation db = Direcation.BEHIND;
        Direcation dl = Direcation.LEFT;
        Direcation dr = Direcation.RIGHT;
        // 自然排序--作比较
        System.out.println(df.compareTo(dr));
        System.out.println(df.compareTo(df));
        System.out.println(dr.compareTo(df));

        // name()
        System.out.println(db.name());

        // ordinal()返回序数
        System.out.println(dl.ordinal());
        System.out.println(d2.toString());
        // valueOf
        Direcation2 front = Enum.valueOf(Direcation2.class, "FRONT");
        System.out.println(front.getName());

        // values
        Direcation3[] values = Direcation3.values();
        for(Direcation3 dd3 : values){
            System.out.println("values--遍历枚举" + dd3);
        }

    }
}
