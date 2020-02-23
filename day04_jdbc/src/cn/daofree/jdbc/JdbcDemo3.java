package cn.daofree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName JdbcDemo3
 * @Description: Statement：执行sql的对象 练习
 *  				    2. account表 修改记录
 * @Author DaoTianXia
 * @Date 2020-02-23-19:17
 * @Version V1.0
 **/
public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3","root","123");
            statement = connection.createStatement();
            String sql = "update account set balance = 1500 where id=5";
            int i = statement.executeUpdate(sql);
            if(i>0){
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
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

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
