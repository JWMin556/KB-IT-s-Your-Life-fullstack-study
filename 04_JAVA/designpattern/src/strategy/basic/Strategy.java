package strategy.basic;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
