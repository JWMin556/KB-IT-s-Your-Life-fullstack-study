package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
        "org.scoula.advice",
        "org.scoula.sample.service"
})
@EnableAspectJAutoProxy
public class RootConfig {
    // 여기서 주로 db 설정을 한다. 
    // 일단은 비워둠
}
