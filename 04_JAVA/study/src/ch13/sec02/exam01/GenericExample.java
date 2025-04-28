package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        //K는Tv로대체, M은String으로대체
        Product<Tv, String> product1 = new Product<>();
        //Setter 매개값은반드시Tv와String을제공
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");
        //Getter 리턴값은Tv와String이됨
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        //K는Car로대체, M은String으로대체
        Product<Car, String> product2 = new Product<>();
        //Setter 매개값은반드시Car와String을제공
        product2.setKind(new Car());
        product2.setModel("SUV자동차");
        //Getter 리턴값은Car와String이됨
        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
