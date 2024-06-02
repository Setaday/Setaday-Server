package com.meet.room.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // STOMP를 사용할 땐 메시지 핸들러가 필요 없음
@RequiredArgsConstructor
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    // 메시지 구독 요청 : /topic (Application Destination Prefix)
    // 메시지 발행 요청 : /kafka (enable Simple Broker)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/kafka");
    }

    // Stomp WebSocket Endpoint : /ws-chat
    // 클라이언트에서 해당 주소로 웹소켓통신을 보내면, 해당 통신을 stomp 기반으로 인식 및 변경
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/enter")
            .setAllowedOrigins("*");
    }
}
