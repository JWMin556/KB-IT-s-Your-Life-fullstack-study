package ch16.sec01;

public class LambdaExample {
    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y); //x와 y를 진짜 calculate에 보낸다. 값만 알지 실제 어떤 계산인지 모른다. 즉, 전달받은 람다식에 따라 다르게 실행됨
    }
    public static void main(String[] args) {
        // 실제 calculate를 구현하는 것이다. 
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });
        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }
}
