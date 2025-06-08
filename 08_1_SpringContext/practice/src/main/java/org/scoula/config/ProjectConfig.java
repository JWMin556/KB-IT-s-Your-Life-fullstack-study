package org.scoula.config;

import org.scoula.domain.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula")
public class ProjectConfig {

    @Bean(name = "꼬미")
    Dog dog1() {
        var d = new Dog();
        d.setBreed("푸들");
        d.setName("꼬미");
        return d;
    }

    @Bean(name = "밤비")
    Dog dog2() {
        var d = new Dog();
        d.setBreed("시바견");
        d.setName("밤비");
        return d;
    }

    @Bean(name = "해피")
    Dog dog3() {
        var d = new Dog();
        d.setBreed("진돗개");
        d.setName("해피");
        return d;
    }
}
