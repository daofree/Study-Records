package cn.daofree.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieDemo1
 * @Description: Cookie快速入门
 * @Author DaoTianXia
 * @Date 2020-02-06-13:44
 * @Version V1.0
 **/
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建cookie对象
        Cookie cookie = new Cookie("msg", "hellocookie");
        // 让response发送cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
