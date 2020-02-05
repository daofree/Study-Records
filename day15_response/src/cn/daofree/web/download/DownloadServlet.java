package cn.daofree.web.download;

import cn.daofree.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName DownloadServlet
 * @Description: 文件下载需求
 * @Author DaoTianXia
 * @Date 2020-02-06-02:06
 * @Version V1.0
 **/
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联--即读进内存了
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition

        //解决filename中文文件名问题；360用url编码，火狐是base64....

        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        // 设置中文名
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中// 流的对拷，文件对拷的操作
        ServletOutputStream sos = response.getOutputStream();
        // 一个字节数组的缓冲区
        byte[] buff = new byte[1024 * 8];
        // 读到的个数
        int len = 0;
        while((len = fis.read(buff)) != -1){
            // 输出流不停的往外写
            sos.write(buff,0,len);
        }

        // 字节流不用刷新
        fis.close();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
