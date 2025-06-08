package org.scoula.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
    private String name = "Ella";

    @Autowired  // Parrot2 타입의 bean을 자동 주입
    private Parrot2 parrot; // setter없이 만들려고 

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Parrot2 getParrot() {
        return parrot;
    }
    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }
}
