package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog d1 = context.getBean("꼬미", Dog.class);
        Dog d2 = context.getBean("밤비", Dog.class);
        Dog d3 = context.getBean("해피", Dog.class);

        System.out.println("[1] 등록된 강아지 목록: ");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
