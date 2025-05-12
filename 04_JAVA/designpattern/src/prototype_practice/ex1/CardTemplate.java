package prototype_practice.ex1;

public class CardTemplate implements Product {
    private String title;
    private char frameChar;

    public CardTemplate(char frameChar) {
        this.frameChar = frameChar;
    }

    @Override
    public void use(String s) {
        if (s.equals("insta")) {
            this.title = s;
            System.out.println("[Instagram Post]");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("오늘 점심은 연남동 김밥 \uD83C\uDF59");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else if (s.equals("youtube")) {
            this.title = s;
            System.out.println("[YouTube Thumbnail]");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\uD83D\uDD25자바로 구현한 내 인생 첫 프로그램!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
