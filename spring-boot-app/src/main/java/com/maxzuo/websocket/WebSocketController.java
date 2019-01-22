package com.maxzuo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Set;

/**
 * WebSocket服务端
 * Created by zfh on 2018/10/31
 */
@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;

    /**
     * 客户端点餐信息
     */
    @MessageMapping("/message")
    public void handlerMessage (@Payload String body, Principal principal) {

        System.out.println("当前在线人数：" + userRegistry.getUserCount());
        Set<SimpUser> users = userRegistry.getUsers();
        System.out.println("users: " + users);

        String name = principal.getName();
        System.out.println("currentUser：" + name);
        messagingTemplate.convertAndSendToUser(name, "/topic/message", body);
    }
}
