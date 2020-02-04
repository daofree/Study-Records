package cn.daofree.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletDemo4
 * @Description: 定义多个访问路径，资源路径3种定义规则
 *
 * //@WebServlet({"/d4","/dd4","/ddd4"})
 * //@WebServlet("/user/demo4")
 * //@WebServlet("/user/*")
 * //@WebServlet("/*")
 * //@WebServlet("*.do")
 *
 * @Author DaoTianXia
 * @Date 2020-02-04-10:31
 * @Version V1.0
 **/
@WebServlet({"/demo4","/d4","/dd4"})
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("定义多个访问路径");
        System.out.println(req);
        //req==org.apache.catalina.connector.RequestFacade@aa4482e
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
