package ch08.practice.exercise2;

public class Main {
    public static void main(String[] args) {
//        Payment payment = new CreditCard();
//        payment.pay(5000);
//        payment.approve();
//        payment.cancel("단순 변심");

        Payment payment = new KakaoPay();
        payment.pay(3000);       // 실패 케이스
        payment.pay(7000);       // 성공 케이스
        payment.approve();
        payment.cancel("오입력");
    }
}
