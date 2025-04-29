package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        Product<Tv, String> product1 = new Product<>();
        // 위에서 지정한 타입으로 사용해야 함
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        // 다른 타입을 원한다면 새로 만들어야 한다.
        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV자동차");
        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
