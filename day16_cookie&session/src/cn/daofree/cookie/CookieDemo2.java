package cn.daofree.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieDemo2
 * @Description: Cookie快速入门，获取cookie
 * @Author DaoTianXia
 * @Date 2020-02-06-13:30
 * @Version V1.0
 **/
@WebServlet("/cookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 我们自己可以获取请求头（cookie:msg=hello），解析出来的，但用封装好的api
        //3. 获取Cookie
        Cookie[] cs = req.getCookies();
        //获取数据，遍历Cookies
        if(cs != null){
            for (Cookie c : cs) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name+":"+value);
            }
        }
//        JSESSIONID:0DF8BB3AE085B178559341868BFF631C
//        msg:hellocookie
//        Idea-c3236388:b07b5cb9-822e-41a2-85f7-70c906f8b5db
//        JSESSIONID:2C6F9784343FBBBA2147E6609B392A4A
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }
}
