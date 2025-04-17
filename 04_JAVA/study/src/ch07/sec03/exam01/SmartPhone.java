package ch07.sec03.exam01;

public class SmartPhone extends Phone {
    //자식생성자선언
    public SmartPhone(String model, String color) {
        super();
        this.model= model;
        this.color= color;
        System.out.println("SmartPhone(String model, String color) 생성자실행됨");
    }
}
