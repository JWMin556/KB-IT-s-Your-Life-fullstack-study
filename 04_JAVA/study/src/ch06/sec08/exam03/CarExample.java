package ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setGas(5);

        if (myCar.isLeftGas()) { //gas가 남은 경우에만 실행
            System.out.println("출발합니다.");
            myCar.run();
        }

        System.out.println("gas를 주입하세요.");
    }
}
