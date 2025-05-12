package prototype.framework;

public interface Product extends Cloneable {
    // Cloneable은 오버라이드가 없다. 즉, 구현 메서드가 없다.
    void use(String s);
    Product createCopy();
}
