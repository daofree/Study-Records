package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo1
 * @Description: 过滤器快速入门;  /*---访问所有资源之前，都会执行该过滤器
 *                              /demo.jsp
 * @Author DaoTianXia
 * @Date 2020-02-08-20:11
 * @Version V1.0
 **/
//@WebFilter("/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1.......");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 放行后还回来
    }

    @Override
    public void destroy() {

    }
}
