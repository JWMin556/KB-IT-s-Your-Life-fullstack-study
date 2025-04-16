package ch06.sec06.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();  //자동 생성자

        System.out.println("모델명: " + myCar.model);
        System.out.println("시동여부: " + myCar.start);
        System.out.println("현재 속도: " + myCar.speed);
    }
}
