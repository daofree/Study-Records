package cn.daofree.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName ServletContextDemo1
 * @Description: ServletContext功能: 获取文件的真实(服务器)路径,注意三种配置文件路径
 * @Author DaoTianXia
 * @Date 2020-02-05-23:15
 * @Version V1.0
 **/
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*

            ServletContext功能：
               1. 获取MIME类型：

                2. 域对象：共享数据
                3. 获取文件的真实(服务器)路径
         */
        
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();


        // 获取文件的服务器路径
        String b = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);
       // File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);

        //  /文件名 的/代表 项目位置
        // 部署项目方式3中配置文件的位置docBase="D:\IdeaProjects\Study-Records\out\artifacts\day15_response_war_exploded"
//        D:\IdeaProjects\Study-Records\out\artifacts\day15_response_war_exploded\b.txt
//        D:\IdeaProjects\Study-Records\out\artifacts\day15_response_war_exploded\WEB-INF\c.txt
//        D:\IdeaProjects\Study-Records\out\artifacts\day15_response_war_exploded\WEB-INF\classes\a.txt
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
