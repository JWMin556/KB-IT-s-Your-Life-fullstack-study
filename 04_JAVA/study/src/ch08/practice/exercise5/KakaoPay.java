package ch08.practice.exercise5;

public class KakaoPay implements Payment {
    private int myAmount = 0;

    @Override
    public boolean pay(int amount) {
        if (amount >= 5000) {
            System.out.println("[카카오페이] " + amount + "원 결제 성공");
            this.myAmount = amount;
            return true;
        } else {
            System.out.println("[카카오페이] 결제 실패: 최소 결제 금액은 5000원입니다.");
            return false;
        }
    }

    @Override
    public void approve() {
        System.out.println("[카카오페이] 간편결제 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[카카오페이] 결제 취소됨 - 사유: <사유>: " + reason);
        this.myAmount = 0;
    }

    public void sendNotification() {
        System.out.println("[카카오페이] 결제 알림이 전송되었습니다!");
    }
}
