package com.maxzuo.websocket;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * WebSocket服务端
 * Created by zfh on 2018/10/31
 */
@RestController
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /** 客户端点餐信息（websocket消息） */
    @MessageMapping("/message")
    public void handlerWebSocketMessage (@Payload String body) {
        logger.info("客户端说：" + body);
        messagingTemplate.convertAndSend("/topic/message", body);
    }

    /** 取消订单（http请求）*/
    @GetMapping("/cancelFoodPresale")
    public String cancelFoodPresale () {
        // 发送websocket消息
        Map<String, Object> body = new HashMap<>(16);
        body.put("message", "hello test");
        messagingTemplate.convertAndSend("/topic/message", JSON.toJSON(body));
        return "hello test";
    }
}
