package com.maxzuo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket STOMP服务端
 * Created by zfh on 2018/10/30
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketServerConfig implements WebSocketMessageBrokerConfigurer {

    private static final Integer HEART_BEAT = 10000;

    /**
     * WebSocket客户端需要连接到的端点的HTTP URL，以便进行WebSocket握手
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/payBoot/live").setAllowedOrigins("*");
    }

    /**
     * 配置MessageBroker
     *  1.客户端发送的目的地 /app开头会被路由到@MessageMapping注解的方法
     *  2.使用内置简单的message borker处理客户端的订阅请求，消息广播到具有匹配目标的连接客户机
     *  3.配置一个任务线程支持心跳，默认不发送心跳到客户端，不接受客户端心跳。
     *  4.分布式扩展可以使用External Broker配置RabbitMQ等中间件。
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
        te.setPoolSize(1);
        te.setThreadNamePrefix("wss-heartbeat-thread-");
        te.initialize();
        registry.enableSimpleBroker("/topic")
                .setHeartbeatValue(new long[]{HEART_BEAT, HEART_BEAT})
                .setTaskScheduler(te);
    }
}
