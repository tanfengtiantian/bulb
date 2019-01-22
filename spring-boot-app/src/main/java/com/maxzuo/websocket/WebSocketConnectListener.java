package com.maxzuo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.security.Principal;

/**
 * 客户端websocket连接事件
 * Created by zfh on 2018/12/09
 */
@Component
public class WebSocketConnectListener implements ApplicationListener<SessionConnectEvent> {

    private final static Logger logger = LoggerFactory.getLogger(WebSocketConnectListener.class);

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
        Principal user = headerAccessor.getUser();
        logger.info("listener: " + user.getName());
    }
}
