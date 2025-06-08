package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.scoula"})
public class RootConfig {
    // 여기서 주로 db 설정을 한다. 
    // 일단은 비워둠
}
