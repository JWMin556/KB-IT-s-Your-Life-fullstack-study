package prototype_practice.ex2;

public interface Product extends Cloneable {
    void use(String content);
    Product createCopy();
}
