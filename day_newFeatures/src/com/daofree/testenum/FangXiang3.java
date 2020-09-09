package com.daofree.testenum;

/**
 * @ClassName FangXiang
 * @Description: 自定义枚举3---抽象方法
 * @Author DaoTianXia
 * @Date 2020-07-25-18:29
 * @Version V1.0
 **/
public abstract class FangXiang3 {

    private String name;
    // 创建4个实例

    public static final FangXiang3 QIAN = new FangXiang3("前"){
        @Override
        public void show() {
            System.out.println("你的选择没有错" + "0");
        }
    };
    public static final FangXiang3 HOU = new FangXiang3("后") {
        @Override
        public void show() {
            System.out.println("你的选择没有错" + "1");
        }
    };
    public static final FangXiang3 ZUO = new FangXiang3("左") {
        @Override
        public void show() {
            System.out.println("你的选择没有错" + "2");
        }
    };
    public static final FangXiang3 YOU = new FangXiang3("右") {
        @Override
        public void show() {
            System.out.println("你的选择没有错" + "3");
        }
    };

    private FangXiang3(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Show.加入抽象方法
     */
    public abstract void show();
}
