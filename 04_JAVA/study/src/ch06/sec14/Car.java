package ch06.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    // 디폴트 생성자 필요
//    public Car() {
//    }

    // 전체를 받아주는 생성자 필요
//    public Car(int speed, boolean stop) {
//        this.speed = speed;
//        this.stop = stop;
//    }
    // 생성자는 이렇게 아무 파라미터도 없는 것과 모든 파라미터 있는 생성자가 필요하다 -> 대표강사 말씀


    // Getter는 값을 읽는 용도이다.
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed < 0) {
            this.speed = 0;
            return;
        } else {
            this.speed = speed;
        }
    }

    // stop 필드의 Getter/Setter 선언
    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop == true) {
            this.speed = 0;
        }
    }
}
