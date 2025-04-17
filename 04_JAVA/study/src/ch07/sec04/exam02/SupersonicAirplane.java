package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
    // 상수 선언
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if (flyMode == SUPERSONIC) {
            System.out.println("초음속 비행합니다.");
        } else {
            super.fly();  // 기존 부모의 fly를 부른다.
        }
    }
}
