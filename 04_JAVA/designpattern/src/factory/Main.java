package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.crate("Youngin Kim");
        Product card2 = factory.crate("Hunmmin Son");
        Product card3 = factory.crate("Kanna");
        System.out.println();

        card1.use();
        card2.use();
        card3.use();
    }
}
