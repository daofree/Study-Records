package cn.daofree.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName C3p0Demo2
 * @Description: c3p0演示
 * @Author DaoTianXia
 * @Date 2020-02-24-16:02
 * @Version V1.0
 **/
public class C3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1. 获取DataSource，使用默认配置
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 0; i <= 10 ; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + "---" +connection);
            if(i == 5){
                //归还连接到连接池中
                connection.close();
            }
        }

        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1 获取DataSource，使用指定名称配置<named-config name="otherc3p0">
        DataSource ds  = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 1; i <= 10 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
