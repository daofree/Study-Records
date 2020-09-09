package com.daofree.testenum;

/**
 * @ClassName FangXiang
 * @Description: 自定义枚举2----成员变量
 * @Author DaoTianXia
 * @Date 2020-07-25-18:29
 * @Version V1.0
 **/
public class FangXiang2 {

    private String name;
    // 创建4个实例

    public static final FangXiang2 QIAN = new FangXiang2("前");
    public static final FangXiang2 HOU = new FangXiang2("后");
    public static final FangXiang2 ZUO = new FangXiang2("左");
    public static final FangXiang2 YOU = new FangXiang2("右");


    private FangXiang2(String name){
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
