package org.scoula.service;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.MessageDTO;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageService {
    public String sendMessage(MessageDTO dto){
        // 이후 AOP의 적용 대상이 될 메서드이며, 파라미터 로그 및 실행 시간 측정을 적용받는다.
        log.info("메시지 전송됨: {}", dto.getContent());
        return "메시지 전송 완료";
    }
}
