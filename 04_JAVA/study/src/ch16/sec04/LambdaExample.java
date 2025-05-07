package ch16.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();
        //실행문이 두 개 이상이기에 중괄호와 return 필요
        person.action((x, y) -> {
            double result = x + y;
            return result;
        });
        //리턴문이 하나만 있을 경우 리턴과 중괄호 생략 가능
        //person.action((x, y) -> {
        // return (x + y);
        //});
        person.action((x, y) -> (x + y));

        //person.action((x, y) -> {
        // return sum(x, y);
        //});
        person.action((x, y) -> sum(x, y));
    }

    public static double sum(double x, double y) {
        return (x + y);
    }
}
