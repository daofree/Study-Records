package cn.daofree.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieDemo5
 * @Description: cookie能不能存中文？一般可以，特殊不行
 * @Author DaoTianXia
 * @Date 2020-02-06-15:11
 * @Version V1.0
 **/
@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg","你好");
        //设置path，让当前服务器下部署的所有项目共享Cookie信息
        c1.setPath("/");

        //3.发送Cookie
        response.addCookie(c1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
