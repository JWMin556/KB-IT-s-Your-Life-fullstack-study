package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        Parrot p = context.getBean("miki", Parrot.class);
        // 만약 이름을 부여하지 않고 중복된 타입으로 bean 호출시, NoUniqueBeanDefinitionException이 발생한다. 
        System.out.println(p.getNama());
    }
}
