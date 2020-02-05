package cn.daofree.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletContextDemo1
 * @Description: ServletContext对象的获取:org.apache.catalina.core.ApplicationContextFacade@109bddec
 * @Author DaoTianXia
 * @Date 2020-02-05-23:15
 * @Version V1.0
 **/
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         /*

            ServletContext对象获取：
                1. 通过request对象获取
			        request.getServletContext();
                2. 通过HttpServlet获取
                    this.getServletContext();
         */

        //1. 通过request对象获取
        ServletContext context1 = req.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);

        System.out.println(context1 == context2);//true
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }
}
