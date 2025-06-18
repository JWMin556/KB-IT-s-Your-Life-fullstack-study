package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // 설정 클래스임을 명시
@EnableWebSocketMessageBroker // WebSocket 메시지 브로커 기능 활성화 (STOMP 사용 가능)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 메시지 브로커 구성 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        // ✅ 클라이언트가 구독할 주소(prefix), 예: /topic/chat
        //    서버가 이 주소로 메시지 발행 시 구독자 모두가 수신

        config.setApplicationDestinationPrefixes("/app");
        // ✅ 클라이언트가 메시지를 보낼 주소(prefix), 예: /app/hello
        //    @MessageMapping("/hello") 컨트롤러 메서드로 라우팅됨
    }

    // STOMP 연결 엔드포인트 설정 메서드
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-app")
                // ✅ 클라이언트가 최초 WebSocket 연결 요청 시 사용할 엔드포인트
                //    → ws://localhost:8080/chat-app

                .setAllowedOrigins("*");
        // ✅ CORS 설정 (모든 오리진에서 접속 허용)
    }
}