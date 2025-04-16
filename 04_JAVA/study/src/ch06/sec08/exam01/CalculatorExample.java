package ch06.sec08.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator(); //Calculator 객체 생성
        myCalc.powerOn(); //리턴값이 없는 powerOn() 메소드 호출

        // 메소드의 리턴값과 받아오는 변수의 타입이 일치해야 한다.
        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);

        int x = 10;
        int y = 4;
        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);

        myCalc.powerOff();
    }
}
