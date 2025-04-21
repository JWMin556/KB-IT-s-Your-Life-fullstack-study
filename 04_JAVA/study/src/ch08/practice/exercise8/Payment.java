package ch08.practice.exercise8;

public interface Payment {
    boolean pay(int amount);      // 결제: 성공 여부 반환
    void approve();               // 승인
    void cancel(String reason);   // 취소

    default boolean beforePay() {
        System.out.println("[공통] 결제를 준비합니다...");
        return true;
    }

    static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
