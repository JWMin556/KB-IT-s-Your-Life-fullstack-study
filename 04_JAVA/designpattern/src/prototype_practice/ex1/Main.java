package prototype_practice.ex1;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        CardTemplate temp1 = new CardTemplate('~');
        CardTemplate temp2 = new CardTemplate('#');

        manager.register("insta", temp1);
        manager.register("youtube", temp2);

        Product p1 = manager.create("insta");
        Product p2 = manager.create("youtube");

        p1.use("insta");
        p2.use("youtube");
    }
}
