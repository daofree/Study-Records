package cn.daofree.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author DaoTianXia
 * @create 2020-02-03-18:52
 * Servlet 快速入门
 */
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @Author daofree
     * @Description 提供服务的方法
     * @Date 19:15 2020/2/3
     * @Param [servletRequest, servletResponse]
     * @return void
     **/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
