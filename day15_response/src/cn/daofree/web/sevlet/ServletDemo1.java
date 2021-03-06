package cn.daofree.web.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletDemo1
 * @Description: 5xx：服务器端错误。代表：500(服务器内部出现异常)
 * @Author DaoTianXia
 * @Date 2020-02-05-12:20
 * @Version V1.0
 **/
@WebServlet("/servletDemo1")
public class ServletDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 3/0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
