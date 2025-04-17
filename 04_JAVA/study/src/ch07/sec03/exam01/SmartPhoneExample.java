package ch07.sec03.exam01;

public class SmartPhoneExample {
    public static void main(String[] args) {
        //SmartPhone객체생성
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
        //Phone으로부터상속받은필드읽기
        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);
    }
}
