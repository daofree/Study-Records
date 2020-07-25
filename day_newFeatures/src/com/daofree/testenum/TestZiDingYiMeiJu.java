package com.daofree.testenum;

/**
 * @ClassName TestZiDingYiMeiJu
 * @Description: 测试自定义枚举
 * @Author DaoTianXia
 * @Date 2020-07-25-18:32
 * @Version V1.0
 **/
public class TestZiDingYiMeiJu {
    public static void main(String[] args) {
        // 第一版自定义枚举类
        FangXiang qian = FangXiang.QIAN;
        // 地址值com.daofree.testenum.FangXiang@75412c2f
        System.out.println(qian);
        // 第二版自定义枚举类--成员变量
        FangXiang2 hou = FangXiang2.HOU;
        System.out.println(hou);
        System.out.println(hou.getName());
        // 第二版自定义枚举类--抽象方法
        FangXiang3 zuo = FangXiang3.ZUO;
        System.out.println(zuo);
        System.out.println(zuo.getName());
        zuo.show();

    }
}
