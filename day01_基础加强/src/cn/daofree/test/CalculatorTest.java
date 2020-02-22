package cn.daofree.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName CalculatorTest
 * @Description: Junit
 * @Author DaoTianXia
 * @Date 2020-02-22-17:18
 * @Version V1.0
 **/
public class CalculatorTest {


    /**
     * 初始化方法：
     *  用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     *
     * @Description:
     *         测试add方法
     * @param: []
     * @return: void
     * @Author: daofree
     * @Date: 17:19 2020/2/22
     *
     */
    @Test
    public void testAdd(){
        System.out.println("...........");
    }
}
