package cn.daofree.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo
 * @Description: 注解servlet,不需要配置文件了
 * @Author DaoTianXia
 * @Date 2020-02-03-23:40
 * @Version V1.0
 **/
@WebServlet("/demo3")  // (urlPatterns = "/demo")  (value = "/demo2")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("JavaEE 6之后servlet 3.0...来了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
