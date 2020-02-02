package cn.daofree.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author DaoTianXia
 * @create 2020-02-02-21:56
 * Jsoup 之XPath快速查询。
 * XPath是对DOM树（Jsoup获得的document）操作的。
 */

public class JsoupDemo6XPath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        // 1获取student.xml的path
        String path = JsoupDemo6XPath.class.getClassLoader().getResource("student.xml").getPath();
        // 2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // document是Jsoup里面的，与XPath不互通

        // 3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        // 4.结合xpath语法查询
        // 4.1查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("--------------------");

        // 4.2查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }

        System.out.println("--------------------");

        // 4.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("------##########-----");


        // 4.4查询student标签下带有id属性的name标签 并且id属性值为daofree
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='daofree']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }




    }
}
