package cn.daofree.junit;

/**
 * @ClassName CalculatorTest
 * @Description: 测试类
 * @Author DaoTianXia
 * @Date 2020-02-22-16:53
 * @Version V1.0
 **/
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 2);
        System.out.println(add);
    }
}
