package ch07.sec03.exam02;

public class SmartPhone extends Phone{
    //자식 생성자 선언
    public SmartPhone(String model, String color) {
        // 부모에 기본 생성자가 없을 경우 명시적으로 호출
        // super: 부모 클래스 의미
        super(model, color);
        System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
    }
}
