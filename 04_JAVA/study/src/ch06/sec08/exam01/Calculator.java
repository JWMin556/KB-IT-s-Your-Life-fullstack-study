package ch06.sec08.exam01;

public class Calculator {
    // 리턴이 void면 리턴값이 없다는 것이다.
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    //리턴값이 없는 메소드 선언
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }
    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 int를 리턴하는 메소드 선언
    // 매개변수가 int값 두 개이고 int를 리턴하는 함수이다.
    int plus(int x, int y) {
        int result = x + y;
        return result; //리턴값 지정;
    }

    //호출 시 두 정수 값을 전달받고,
    //호출한 곳으로 결과값 double을 리턴하는 메소드선언
    // int값 두 개의 파라미터이고 double을 리턴하는 함수
    double divide(int x, int y) {
        double result = (double)x / (double)y;
        return result; //리턴값 지정;
    }
}
