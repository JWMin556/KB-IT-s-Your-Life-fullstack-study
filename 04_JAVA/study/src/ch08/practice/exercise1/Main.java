package ch08.practice.exercise1;

public class Main {
    public static void main(String[] args) {
        Payment payment = new CreditCard();
        payment.pay(10000);
        payment.approve();
    }
}
