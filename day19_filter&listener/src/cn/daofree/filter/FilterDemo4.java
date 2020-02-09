package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo4
 * @Description: 4种拦截路径配置
 * @Author daofree
 * @Date 2020-02-09-0:52
 * @Version V1.0
 * //@WebFilter("/index.jsp") //1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
 * //@WebFilter("/user/*") //2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行
 * //@WebFilter("*.jsp")   //3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
 **/

//@WebFilter("/*")
public class FilterDemo4 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4....");
        chain.doFilter(req, resp);
        System.out.println("=============");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
