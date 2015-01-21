package com.jita.erhuo.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by guitar on 15/1/20.
 */
public class RedisManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);

    private JedisPool pool = null;

    private static RedisManager INSTANCE = null;

    private RedisManager() {
        PropertiesConfiguration config = null;
        try {
            config = new PropertiesConfiguration("redis.properties");
        } catch (ConfigurationException e) {
            logger.error("redis的配置文件不存在",e);
        }

        pool = new JedisPool(new JedisPoolConfig(),
                config.getString("redis.host"),
                config.getInt("redis.port"));
        logger.info("redis pool init");
    }

    public static RedisManager getInstance(){
        if(INSTANCE==null){
            return new RedisManager();
        }else{
            return INSTANCE;
        }
    }

    public JedisPool getPool() {
        return pool;
    }

    public void shutdown() {
        pool.destroy();
    }

}
