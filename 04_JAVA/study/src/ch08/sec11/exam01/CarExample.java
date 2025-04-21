package ch08.sec11.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        //이렇게 작동하는 것이 리스코프 치환의 원칙이다. -> 메인 로직에 영향x
        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();
        myCar.run();
    }
}
