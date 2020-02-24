package cn.daofree.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName DruidDemo
 * @Description: Druid：数据库连接池实现技术，由阿里巴巴提供的-----Druid演示
 * @Author DaoTianXia
 * @Date 2020-02-24-17:36
 * @Version V1.0
 **/
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5.获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
