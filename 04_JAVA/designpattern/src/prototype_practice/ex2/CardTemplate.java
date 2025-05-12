package prototype_practice.ex2;

public class CardTemplate implements Product, Cloneable {
    private String title;
    private char frameChar;

    public CardTemplate(String title, char frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    @Override
    public void use(String content) {
        String border = String.valueOf(frameChar).repeat(content.length() + 10);
        System.out.println("[" + title + "]");
        System.out.println(border);
        System.out.println(content);
        System.out.println(border);
        System.out.println();
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getTitle() {
        return title;
    }
}
