package cn.daofree.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo1
 * @Description: 自己实现Servlet，烦！有别人实现吗？
 * @Author DaoTianXia
 * @Date 2020-02-04-9:34
 * @Version V1.0
 **/
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("day14_demo1........");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
