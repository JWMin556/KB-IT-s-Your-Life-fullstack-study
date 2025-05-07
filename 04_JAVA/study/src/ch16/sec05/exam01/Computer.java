package ch16.sec05.exam01;

public class Computer {
    // 둘 다 Calcuable 인터페이스의 추상메서드의 형태와 완전히 동일한 형태이다. (double 파라미터 두 개, double 한개 반환)
    // 둘 다 action에 넣어서 사용할 것이기 때문에 calc의 형태를 따른다.
    public static double staticMethod(double x, double y) {
        return x + y;
    }
    public double instanceMethod(double x, double y) {
        return x * y;
    }
}
