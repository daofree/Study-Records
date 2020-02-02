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
 * Jsoup Document/Element对象
 */

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        // 1获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // 2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象了。
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("-----------");

        //3.2 获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("-----------");

        //3.2获取 number属性值为heima_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "daofree_0001");
        System.out.println("E2=="+ elements2);

        System.out.println("-----------");
        //3.3获取id属性值的元素对象
        Element itcast = document.getElementById("daofree");
        System.out.println("id======="+itcast);


    }
}
