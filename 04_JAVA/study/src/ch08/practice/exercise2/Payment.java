package ch08.practice.exercise2;

public interface Payment {
    void pay(int amount);
    void approve();
    void cancel(String reason);
}
