package adapter.adapter2;

public class Main {
    public static void main(String[] args) {
        // 상속으로 만든 것인지 위임으로 만든 것인지 알 수 없다.
        Print p = new PrintBanner("HEllo");
        p.printWeak();
        p.printStrong();

        print(new PrintBanner(new Banner("Hello Banner")));
    }

    public static void print(Print p) {
        p.printWeak();
        p.printStrong();
    }
}
