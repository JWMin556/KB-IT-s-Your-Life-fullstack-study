package ch06.sec07.exam04;

public class Car {
    //필드선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    public Car() {} //생성자 선언

    // 매개변수의 타입, 개수, 순서가 다르게 여러 생성자 오버로딩 가능
    public Car(String model) {
        this.model = model;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
