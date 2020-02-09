package cn.daofree.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;

/**
 * @ClassName ContextLoderListener
 * @Description: 监听器
 * @Author DaoTianXia
 * @Date 2020-02-09-21:25
 * @Version V1.0
 **/
@WebListener
public class ContextLoderListener implements ServletContextListener {
    /**
     * 监听ServletContext对象创建的。ServletContext对象服务器启动后自动创建。
     *
     * 在服务器启动后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //加载资源文件---全局资源文件ServletContext
        //1.获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        System.out.println("contextConfigLocation"+contextConfigLocation);
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        System.out.println("realPath"+realPath);
        //4.加载进内存
        try{
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了。。。");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("ServletContext对象被销毁了。。。");
    }
}
