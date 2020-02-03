package cn.daofree.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ServletDemo2
 * @Description: Servlet中的方法--生命周期
 * @Author DaoTianXia
 * @Date 2020-02-03-21:15
 * @Version V1.0
 **/
public class ServletDemo2 implements Servlet {

    /**
     *
     * @Description:
     *         初始化方法，加载资源，在servlet被创建是执行。只会执行一次。加载资源多时或者执行前需要依赖其他servlet。
     * @param: [servletConfig]
     * @return: void
     * @Author: daofree
     * @Date: 22:36 2020/2/3
     *
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...........");

    }

    /**
     *
     * @Description:
     *         获取ServletConfig对象，需要实现
     *         ServletConfig：Servlet的配置对象。
     * @param: []
     * @return: javax.servlet.ServletConfig
     * @Author: daofree
     * @Date: 22:55 2020/2/3
     *
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *
     * @Description:
     *         提供服务的方法。每一次servlet被访问，都会执行。执行多次。
     * @param: [servletRequest, servletResponse]
     * @return: void
     * @Author: daofree
     * @Date: 22:46 2020/2/3
     *
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...........");
    }

    /**
     *
     * @Description: 
     *         获取Servlet的一些信息，版本，作者。。。
     * @param: []
     * @return: java.lang.String 
     * @Author: daofree
     * @Date: 22:56 2020/2/3
     *
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     *
     * @Description: 
     *         销毁方法：在服务器正常关闭时，执行，释放资源，执行一次。
     * @param: []
     * @return: void 
     * @Author: daofree
     * @Date: 22:47 2020/2/3
     *
     */
    @Override
    public void destroy() {
        System.out.println("destroy...........");
    }
}
