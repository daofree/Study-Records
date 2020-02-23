package cn.daofree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcDemo2
 * @Description: Statement：执行sql的对象 练习
 *              1.account表 添加一条记录
 * @Author DaoTianXia
 * @Date 2020-02-23-18:58
 * @Version V1.0
 **/
public class JdbcDemo2 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into account values(null,'王五',3000)";
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "123");
            statement = conn.createStatement();
            // 影响的行数
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 若获取连接失败，===》空.close()====空指针异常！！
//            statement.close();
            //7. 释放资源
            //避免空指针异常
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
