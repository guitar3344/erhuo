package com.jita.erhuo.util;

import com.mongodb.*;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by guitar on 15/1/20.
 */
public class MongoManager {
    private static Logger logger = LoggerFactory.getLogger(MongoManager.class);

    private MongoManager() {

    }

    private static Mongo mongo = null;

    public static void init() {
        PropertiesConfiguration config = null;
        try {
            config = new PropertiesConfiguration("mongodb.properties");
        } catch (ConfigurationException e) {
            logger.error("mongodb的配置文件不存在",e);
        }

        String[] url = config.getStringArray("url");// url
        int poolSize = config.getInt("poolSize");// 连接数量
        int blockSize = config.getInt("blockSize"); // 等待队列长度
        // 其他参数根据实际情况进行添加
        try {
            if (url.length > 1) {
                List<ServerAddress> setList = new ArrayList<ServerAddress>();
                for (String u : url) {
                    String ip = u.split(":")[0];
                    String port = u.split(":")[1];
                    setList.add(new ServerAddress(ip, Integer.parseInt(port)));
                }
                mongo = new MongoClient(setList);
            } else {
                String ip = url[0].split(":")[0];
                String port = url[0].split(":")[1];
                mongo = new MongoClient(ip, Integer.parseInt(port));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            logger.error("MongoDB创建Client失败：未知的主机端口", e);
        }

        MongoOptions opt = mongo.getMongoOptions();
        opt.connectionsPerHost = poolSize;
        opt.threadsAllowedToBlockForConnectionMultiplier = blockSize;
    }

    public static DB getDB(String dbName) {
        if (mongo == null) {
            init();
        }
        return mongo.getDB(dbName);
    }
}

