package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo2
 * @Description: 过滤器执行流程
 * @Author daofree
 * @Date 2020-02-08-21:09
 * @Version V1.0
 **/
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("FilterDemo2---开始了-----");
        // 放行
        chain.doFilter(req, resp);

        // 对response对象的响应消息增强
        System.out.println("FilterDemo2---回来了-----");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
