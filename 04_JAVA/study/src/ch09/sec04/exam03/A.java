package ch09.sec04.exam03;

public class A {
    public void method1(int arg) {
        int var = 1;
        class B {
            void method2() {
                //로컬 변수 읽기
                System.out.println("arg: " + arg); //(o)
                System.out.println("var: " + var); //(o)
            }
        }

        B b = new B();
        //로컬 객체 메소드 호출
        b.method2();
    }
}
