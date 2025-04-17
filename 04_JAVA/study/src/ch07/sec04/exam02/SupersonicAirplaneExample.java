package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff(); // 자식 클래스가 갖고 있지 않은 메소드는 부모 메소드이다.
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;  // 상수니까 static이 붙었으니 인스턴스가 아니라 클래스명을 직접 사용
        sa.fly();
        sa.flyMode= SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
