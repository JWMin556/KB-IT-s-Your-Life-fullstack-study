package ch05.sec05;

public class EqualsExample {
    public static void main(String[] args) {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";
        if(strVar1 == strVar2) { //문자열을 그냥 생성할 경우 값이 같으면 주소도 같다
            System.out.println("strVar1과 strVar2는 참조가 같음");
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다름");
        }
        if(strVar1.equals(strVar2)) { // 그렇지만 값을 비교할 때는 equals를 쓰는게 좋다
            System.out.println("strVar1과 strVar2는 문자열이 같음");
        }

        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");
        if(strVar3 == strVar4) { // 문자열을 new로 생성했을 경우 다른 주소값을 참조
            System.out.println("strVar3과 strVar4는 참조가 같음");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다름");
        }
        if(strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 문자열이 같음");
        }
    }
}
