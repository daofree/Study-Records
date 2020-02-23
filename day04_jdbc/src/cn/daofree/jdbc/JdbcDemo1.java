package cn.daofree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ClassName JdbcDemo1
 * @Description: JDBC快速入门
 * @Author DaoTianXia
 * @Date 2020-02-23-17:24
 * @Version V1.0
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        // 2.注册驱动，5版本之后可省
        //Class.forName("com.mysql.jdbc.Driver");

        // 3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");

        // localhost:3306可简写
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "123");
        //4.定义sql语句
//        String sql = "update account set balance = 2000 where id = 3";

        String sql = "update account set balance = 5000";
        //5.获取执行sql的对象 Statement
        Statement statement = conn.createStatement();
        //6.执行sql
        int count = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        conn.close();


    }
}
