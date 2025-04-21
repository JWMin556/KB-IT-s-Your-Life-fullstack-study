package ch08.practice.exercise8;

public class PaymentManager {
    private int creditCount = 0;
    private int kakaoCount = 0;
    private int amount= 0;

    public void process(Payment payment, int amount) {
        if (payment.pay(amount)) {
            payment.approve();
            payment.cancel("테스트 취소");
            this.amount += amount;
            if (payment instanceof KakaoPay kakaoPay) {
                kakaoPay.sendNotification();
                this.kakaoCount += 1;
            } else {
                System.out.println("[알림 서비스 없음]");
                this.creditCount += 1;
            }
        } else {
            System.out.println("[결제 실패: 승인/취소 건너뜀]");
        }
    }

    public void printSummary() {
        System.out.println("✅ 결제 통계 요약");
        int totalCount = this.creditCount + this.kakaoCount;
        System.out.println("총 결제 횟수: " + totalCount + "회");
        System.out.println("총 결제 금액: " + this.amount + "원");
        System.out.println("[CreditCard] : "+ this.creditCount + "건");
        System.out.println("[KakaoPay] : "+ this.kakaoCount + "건");
    }
}
