package org.scoula.service;

import org.scoula.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("rescueCenter")
public class RescueCenter {
    private final Dog dog;

    @Autowired
    public RescueCenter(@Qualifier("밤비") Dog dog) {
        this.dog = dog;
    }

    @PostConstruct
    public void rescue() {
//        System.out.println("구조한 강아지 정보: ");
//        System.out.println(dog);
    }
}
