package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Spring 설정 클래스 - 얘를 해줘야 Bean을 포함할 수 있다. 
public class ProjectConfig {
    @Bean  // 스프링 컨테이너에 Bean으로 반환값들을 등록한다는 것이다.
    Parrot parrot() { // DI의 대상이다. 이를 통해 맵 객체로 Context가 관리된다. (키-> 문자열, 값-> 인스턴스 참조)
        var p = new Parrot();
        p.setNama("Koko");
        return p;
    }

    // 동일한 타입은 하나의 Bean만 추출가능
    // 같은 타입의 bean이 여러 개면 예외가 발생한다.
    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
