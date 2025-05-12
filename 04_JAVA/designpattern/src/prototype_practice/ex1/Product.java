package prototype_practice.ex1;

public interface Product extends Cloneable {
    void use(String s);
    Product createCopy();
}
