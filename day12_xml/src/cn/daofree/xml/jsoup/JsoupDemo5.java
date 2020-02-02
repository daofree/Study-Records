package cn.daofree.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author DaoTianXia
 * @create 2020-02-02-21:56
 * Jsoup selector:选择器快速查询，方法虽在element里面定义，但在这里Document的对象是继承Element对象的
 * 一般用document调用select
 */

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        // 1获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        // 2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        /*
            div{

            }
         */
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("=----------------");
        //4.查询id值为daofree的元素
        Elements elements1 = document.select("#daofree");
        System.out.println(elements1);
        System.out.println("##############");
        //5.想获取student标签并且number属性值为daofree_0001的age子标签
        //5.1.获取student标签并且number属性值为daofree_0001
        Elements elements2 = document.select("student[number=\"daofree_0001\"]");
        System.out.println(elements2);
        System.out.println("----------------");

        //5.2获取student标签并且number属性值为daofree_0001的age子标签
        Elements elements3 = document.select("student[number=\"daofree_0001\"] > age");
        System.out.println(elements3);



    }
}
