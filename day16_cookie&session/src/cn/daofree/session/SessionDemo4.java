package cn.daofree.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName SessionDemo4
 * @Description: 客户端不关闭，服务器关闭后(内存释放，会话结束，session销毁)，两次获取的session是同一个吗？
 * @Author DaoTianXia
 * @Date 2020-02-07-11:28
 * @Version V1.0
 **/
@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
