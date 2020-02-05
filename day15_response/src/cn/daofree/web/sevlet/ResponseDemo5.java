package cn.daofree.web.sevlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ResponseDemo5
 * @Description: 服务器输出字节数据到浏览器
 * @Author DaoTianXia
 * @Date 2020-02-05-21:01
 * @Version V1.0
 **/
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        //1.获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        //2.输出数据
        // String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组,"你好".getBytes() 得到的是GBK
        sos.write("你好".getBytes("utf-8"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
