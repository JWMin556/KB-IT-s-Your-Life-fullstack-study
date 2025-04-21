package ch08.practice.exercise7;

public class CreditCard implements Payment {
    private int myAmount = 0;

    @Override
    public boolean pay(int amount) {
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        this.myAmount = amount;
        Payment.log("결제 수단: [CreditCard], 금액: " + amount + "원");
        return true;
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[신용카드] " + myAmount + "원 결제 취소 - 사유: " + reason);
        this.myAmount = 0;
    }
}
