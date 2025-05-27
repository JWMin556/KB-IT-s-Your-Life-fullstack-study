package composite.practice;

public class MainStep1 {
    public static void main(String[] args) {
        Member zero = new Member("제로비트", "ENFP", "Vocal", 85);
        Member mint = new Member("민트초코", "ISTJ", "Guitar", 90);
        Member ai = new Member("아이시스", "ISFP", "Keyboard", 25);
        Member dongle = new Member("동글몽", "INTP", "Drums", 70);
        Member honey = new Member("허니콩", "ESFJ", "Bass", 95);

        System.out.println("[밴드 멤버 구성]");
        zero.printStructure("|- ");
        mint.printStructure("|- ");
        ai.printStructure("|- ");
        dongle.printStructure("|- ");
        honey.printStructure("|- ");

        System.out.println("\n[공연 시뮬레이션]");
        zero.perform();
        mint.perform();
        ai.perform();
        dongle.perform();
        honey.perform();
    }
}
