package cn.daofree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcDemo4
 * @Description: Statement：执行sql的对象 练习
 *                  3. account表 删除一条记录
 * @Author DaoTianXia
 * @Date 2020-02-23-19:26
 * @Version V1.0
 **/
public class JdbcDemo4 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "123");
            statement = conn.createStatement();
            String sql = "delete from account where id = 6;";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if (i > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
