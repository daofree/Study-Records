package cn.daofree.web.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ResponseDemo4
 * @Description: 服务器输出字符数据到浏览器
 * @Author DaoTianXia
 * @Date 2020-02-05-18:54
 * @Version V1.0
 **/
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK（只这一步，是要知道客服都是GBK的情况下）
        // resp.setCharacterEncoding("utf-8");

        // 返回编码后的流后，还要告诉人家用什么码解

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
        //resp.setHeader("content-type","text/html;charset=utf-8");

        //有29可以不要24行，因既能设置流编码，还能告诉客户端

        // "content-type"固定的
        //简单的形式，设置编码
        resp.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2.输出数据--这个流的print()可以自动刷新，但PrintWriter自己就可以写出缓存区
        // 此处的PrintWriter是resp获取的，即使是write也不需要刷新，resp一次响应完成后
        // 自动被销毁，获取的流也会被关闭。用write，不刷新，但也可以达到把数据写出缓冲区效果
        //pw.write("hello response");
        // 浏览器会自动解析标签
        //pw.write("<h1>hello response</h1>");
        pw.write("你好啊啊啊 response");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
