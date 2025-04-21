package ch08.practice.exercise5;

public interface Payment {
    boolean pay(int amount);      // 결제: 성공 여부 반환
    void approve();               // 승인
    void cancel(String reason);   // 취소
}
