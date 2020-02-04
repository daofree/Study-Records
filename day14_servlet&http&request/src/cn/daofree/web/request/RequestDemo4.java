package cn.daofree.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示获取请求头数据:referer，需要间接访问才可以。获取的是别的网址！
 * 需要开两个项目演示，tomcat设置。没有网址的超链接访问获取的还是null（==直接访问）
 * @author l
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        //原网址
        System.out.println(referer);
        //这里来的，http://localhost/day14/login.html

        //防盗链
        if(referer != null ){
            if(referer.contains("/day14")){
                //正常访问 http://localhost:8080/day14/RequestDemo4
                // System.out.println("播放电影....")
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("给你播放电影....");
            }else{
                //盗链
                // System.out.println("想看电影吗？来优酷吧...")
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("盗链来的，想看电影吗？来优酷吧...");
            }
        }
    }
}
