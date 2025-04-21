package ch08.practice.exercise1;

public class CreditCard implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("[신용카드]" + amount + "원 결제 완료");
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }
}
