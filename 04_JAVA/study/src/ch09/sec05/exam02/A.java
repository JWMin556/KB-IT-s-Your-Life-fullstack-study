package ch09.sec05.exam02;

public class A {
    String field = "A-field";

    void method() {
        System.out.println("A-method");
    }

    class B {
        String field = "B-field";
        void method() {
            System.out.println("B-method");
        }

        void print() {
            //B 객체의 필드와 메소드 사용
            System.out.println(this.field);
            this.method();
            //A 객체의 필드와 메소드 사용
            System.out.println(A.this.field);
            A.this.method();
        }
    }

    void useB() {
        B b = new B();
        b.print();
    }
}
