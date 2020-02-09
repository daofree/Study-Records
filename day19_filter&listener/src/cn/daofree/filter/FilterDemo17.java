package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo7
 * @Description: 过滤器链(配置多个过滤器)
 * @Author daofree
 * @Date 2020-02-09-1:38
 * @Version V1.0
 **/
@WebFilter("/*")
public class FilterDemo17 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo7.....");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo7....回.");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
