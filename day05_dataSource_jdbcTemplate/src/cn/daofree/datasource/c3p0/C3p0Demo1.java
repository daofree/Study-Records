package cn.daofree.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName C3p0Demo1
 * @Description: C3P0：数据库连接池技术---c3p0的演示
 * @Author DaoTianXia
 * @Date 2020-02-24-15:51
 * @Version V1.0
 **/
public class C3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2. 获取连接对象
        Connection connection = ds.getConnection();
        //3. 打印
        System.out.println(connection);
    }
}
