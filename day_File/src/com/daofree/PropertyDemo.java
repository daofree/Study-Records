package com.daofree;

import java.util.Properties;
import java.util.Set;

/**
 * @ClassName PropertyDemo
 * @Description: 属性集合配置类
 * @Author DaoTianXia
 * @Date 2020-05-31-18:39
 * @Version V1.0
 **/
public class PropertyDemo {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        prop.list(System.out);
    }

    public static void main1(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("user", "lisi");
        pro.setProperty("pwd", "123");
        pro.setProperty("xxx", "yyy");
        Set<String> strings = pro.stringPropertyNames();
        for(String s: strings){
            String property = pro.getProperty(s);
            System.out.println(s + "----------" + property);
        }
    }
}
