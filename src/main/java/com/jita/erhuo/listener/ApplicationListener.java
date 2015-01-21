package com.jita.erhuo.listener;

import com.jita.erhuo.util.RedisManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by guitar on 15/1/20.
 */
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化redis连接池
        RedisManager.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        RedisManager.getInstance().shutdown();
    }
}
