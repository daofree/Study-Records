package cn.daofree.datasource.jdbctemplate;

import cn.daofree.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTemplateDemo1
 * @Description: JdbcTemplate入门
 * @Author DaoTianXia
 * @Date 2020-02-24-18:40
 * @Version V1.0
 **/
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update account set balance = 8000 where id = ?";
        int update = jdbcTemplate.update(sql, 3);
        System.out.println(update);
    }
}
