package ch09.sec03.exam02;

public class AExample {
    public static void main(String[] args) {
        //B 객체생성및인스턴스필드및메소드사용
        A.B b = new A.B();
        System.out.println(b.field1);
        b.method1();
        //B 클래스의정적필드및메소드사용
        System.out.println(A.B.field2);
        A.B.method2();
    }
}
