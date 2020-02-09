package cn.daofree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FilterDemo5
 * @Description: 拦截方式配置：资源被访问的方式（如请求转发）
 * @Author daofree
 * @Date 2020-02-09-1:18
 * @Version V1.0
 * //浏览器直接请求index.jsp资源时，该过滤器会被执行
 * //@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
 *
 * //只有转发访问index.jsp时，该过滤器才会被执行
 * //@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
 *
 * 方式都想过滤掉
 * //浏览器直接请求index.jsp或者转发访问index.jsp。该过滤器才会被执行
 * //@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
 * /*全过滤，问访问/user/updateServlet（里面有个转发），那么FilterDemo5执行几次？？？
 **/
//@WebFilter(value = "/*",dispatcherTypes = DispatcherType.FORWARD)
public class FilterDemo5 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5....");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
