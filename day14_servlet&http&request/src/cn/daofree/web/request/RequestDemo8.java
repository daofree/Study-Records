package cn.daofree.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发：转发到demo9资源
 * @author doafree
 */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
//        requestDispatcher.forward(request,response);


        // 存储数据到request域中
        request.setAttribute("msg","hello");

        request.getRequestDispatcher("/requestDemo9").forward(request,response);
        //request.getRequestDispatcher("https://www.baidu.cn").forward(request,response); 请求转发外部资源失败
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
