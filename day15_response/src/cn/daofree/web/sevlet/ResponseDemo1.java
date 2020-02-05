package cn.daofree.web.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author daofree
 * 重定向302-location-路径，3个参数2个固定！sendRedirect（）
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //访问/responseDemo1，会自动跳转到/responseDemo2资源
        // 1. 设置状态码为302
//        response.setStatus(302);
        // 2.设置响应头location
//        response.setHeader("location","/day15/responseDemo2");

        // ---------二合一--------

        request.setAttribute("msg","response");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        //简单的重定向方法
        response.sendRedirect(contextPath+"/responseDemo2");
        //response.sendRedirect("https://www.baidu.cn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
