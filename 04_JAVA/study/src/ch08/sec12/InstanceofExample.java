package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        ride(taxi);
        System.out.println();
        ride(bus);
    }
    
    public static void ride(Vehicle vehicle) {
//        if (vehicle instanceof Bus) {
//            Bus bus = (Bus) vehicle;
//            bus.checkFare();
//        }
        
        // 최신 방법 -> 즉각 형변환
        // checkFare의 경우 Bus 클래스에만 있기 때문에 instaceof로 타입 체크
        if (vehicle instanceof Bus bus) {
            bus.checkFare();
        }
        vehicle.run();
    }
}
