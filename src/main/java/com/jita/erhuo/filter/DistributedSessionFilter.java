package com.jita.erhuo.filter;

import com.jita.erhuo.util.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by guitar on 15/1/19.
 */
public class DistributedSessionFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String SESSION_ID = "distributed_sessionId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("DistributedSessionFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String sessionId = "";
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(SESSION_ID)){
                    sessionId = cookie.getValue();
                    flag = true;
                    break;
                }
            }
        }

        if(!flag){
//            UUID uuid = UUID.randomUUID();
//            Cookie newCookie = new Cookie(SESSION_ID,uuid.toString());
//            response.addCookie(newCookie);
            response.sendRedirect("login.do");
        }else{
            String sessionStr = RedisManager.getInstance().getPool().getResource().get(SESSION_ID);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("DistributedSessionFilter destroy");
    }
}
