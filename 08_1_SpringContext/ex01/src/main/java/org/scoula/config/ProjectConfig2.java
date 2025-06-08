package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig2 {

    @Bean
    Parrot parrot1 (){
        var p = new Parrot();
        p.setNama("Koko");
        return p;
    }

    @Bean(name = "miki")
    Parrot parrot2 (){
        var p = new Parrot();
        p.setNama("Miki");
        return p;
    }

    @Bean(name = "riki")
    Parrot parrot3() {
        var p = new Parrot();
        p.setNama("Riki");
        return p;
    }
}
