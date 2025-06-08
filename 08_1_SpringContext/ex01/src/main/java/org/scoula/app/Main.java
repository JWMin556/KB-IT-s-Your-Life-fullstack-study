package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Spring Context 생성
        // ProjectConfig.class를 통해 Bean어노테이션이 붙은 모든 메서드들을 한번씩 실행한다. 그러면서 Context가 만들어짐
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 해당 타입의 bean을 context에서 꺼내온다
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getNama());

        Parrot p2 = context.getBean(Parrot.class);  // 또 한번 p2를 꺼내보자
        System.out.println(p2.getNama());

        System.out.println("p와 p2가 같을까? " + (p == p2));  // 결과가 true이다. 
        // 즉, Singleton으로 관리된다는 것이다. 같은 인스턴스 일 수도 있고 다른 인스턴스일 수도 있다. 
        // 지금은 동일하다고 나온다. 즉, 동일한 인스턴스로 보는 것이 디폴트이다. 그러나 프로토타입으로 설정시 새로운 인스턴스로 됨
        // 클론해서 리턴시 prototype이 됨



        String s = context.getBean(String.class); // 보면 앞의 강제 casting을 안해도 됨. 그 이유는 getBean의 타입이 Object가 아니기 때문이다. 매개변수와 동일한 타입으로 리턴된다.
        // 이름으로 얻기
        String s2 = context.getBean("hello", String.class); // 만약 String.class를 안해주면 강제 casting해줘야 함
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
