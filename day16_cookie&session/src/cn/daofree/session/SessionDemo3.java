package cn.daofree.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName SessionDemo3
 * @Description: 当客户端关闭后（会话结束），服务器不关闭，再次打开，两次获取session是否为同一个？
 * @Author DaoTianXia
 * @Date 2020-02-07-10:36
 * @Version V1.0
 **/
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);


        //期望客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
