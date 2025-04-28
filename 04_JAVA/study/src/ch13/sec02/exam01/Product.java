package ch13.sec02.exam01;

//제네릭타입
public class Product<K, M> { // 타입파라미터로K와M 정의
    //타입파라미터를필드타입으로사용
    private K kind;
    private M model;
    //타입파라미터를리턴타입과매개변수타입으로사용
    public K getKind() { return this.kind; }
    public M getModel() { return this.model; }
    public void setKind(K kind) { this.kind = kind; }
    public void setModel(M model) { this.model = model; }
}
