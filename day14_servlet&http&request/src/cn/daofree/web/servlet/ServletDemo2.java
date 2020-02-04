package cn.daofree.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo2
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-04-9:41
 * @Version V1.0
 **/
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet的儿子GenericServlet...继承它只需要实现service..");
    }

}
