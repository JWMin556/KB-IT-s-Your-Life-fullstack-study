package adapter.adapter1;

public class Main {
    public static void main(String[] args) {
//        Print p = new PrintBanner("Hello");  // 선언은 인터페이스, 참조는 adapter로 한다.
//        p.printWeak();
//        p.printStrong();

        print(new PrintBanner("Hello World!"));
    }

    public static void print(Print p) {
        p.printWeak();
        p.printStrong();
    }
}
