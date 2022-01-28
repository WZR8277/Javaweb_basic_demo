package cn.ron.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 JedisPool工具类
    加载配置文件，配置连接池的参数
    提供获取连接的方法

 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static{
        //读取配置文件
        String url = Thread.currentThread().getContextClassLoader().getResource("jedis.properties").getFile();
        //创建Properties对象
        //System.out.println(url);
        InputStream is = null;
        try {
            is = new FileInputStream(url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties pro = new Properties();
        //关联文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));

    }


    /**
     * 获取连接方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
