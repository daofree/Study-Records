package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo3
 * @Description: 过滤器生命周期方法
 * @Author daofree
 * @Date 2020-02-08-22:08
 * @Version V1.0
 **/
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     *
     * @Description: 
     *         在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
     * @param: []
     * @return: void 
     * @Author: daofree
     * @Date: 22:27 2020/2/8
     *
     */
    @Override
    public void destroy() {
        System.out.println("destroy........");
    }

    /**
     *
     * @Description: 
     *         每一次请求被拦截资源时，会执行。执行多次
     * @param: [req, resp, chain]
     * @return: void 
     * @Author: daofree
     * @Date: 22:26 2020/2/8
     *
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter.......前");
        chain.doFilter(req, resp);
        System.out.println("doFilter.......后");
    }

    /**
     *
     * @Description: 
     *         在服务器启动后，会创建Filter对象，然后调用init方法。（服务器帮完成）只执行一次。用于加载资源
     * @param: [config]
     * @return: void 
     * @Author: daofree
     * @Date: 22:26 2020/2/8
     *
     */
    @Override
    public void init(FilterConfig config) throws ServletException {

        System.out.println("init....");
    }

}
