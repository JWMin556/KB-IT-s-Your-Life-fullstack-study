package strategy.basic;

public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        // DI를 통해서 결정되므로 Player는 어떤 전략인지 모른다.
        // 즉, Strategy가 바뀌어도 여기서 수정할 필요가 없어진다. 이게 전략 패턴이다.
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다.
    public Hand nextHand() {
        return strategy.nextHand();
    }
    // 승리
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    // 무승부
    public void even() {
        gamecount++;
    }
    @Override
    public String toString() {
        return "[" +
                name + ":" +
                gamecount + " games, " +
                wincount + " win, " +
                losecount + " lose" +
                "]";
    }
}
