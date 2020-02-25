package cn.daofree.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @ClassName JedisPoolUtils
 * @Description: JedisPool工具类
 *              加载配置文件，配置连接池的参数
 *              提供获取连接的方法
 * @Author DaoTianXia
 * @Date 2020-02-25-11:34
 * @Version V1.0
 **/
public class JedisPoolUtils {


    private static JedisPool jedisPool;

    static {
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        URL resource = JedisPoolUtils.class.getClassLoader().getResource("jedis.properties");
        System.out.println(resource);
        //创建Properties对象
        Properties pro = new Properties();
        System.out.println(is);
        //关联文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        // 初始化JedisPool
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));

    }

    /**
     * 获取连接方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
