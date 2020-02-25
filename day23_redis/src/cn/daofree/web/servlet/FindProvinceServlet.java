package cn.daofree.web.servlet;

import cn.daofree.domain.Province;
import cn.daofree.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName FindProvinceServlet
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-25-16:29
 * @Version V1.0
 **/
@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用service查询
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> list = provinceService.fillAll();
        // 序列化list为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        System.out.println(json);
        // 响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
