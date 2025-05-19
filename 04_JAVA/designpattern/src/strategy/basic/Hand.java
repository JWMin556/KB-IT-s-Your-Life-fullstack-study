package strategy.basic;

// enum의 ROCK이 있다면, ROCK이 하나의 클래스이다. (singleton으로 운영됨)
public enum Hand {
    // ROCK, SCISSORS, PAPER를 영어가 아니라 한글로 
    ROCK("바위", 0),
    SCISSORS("가위", 1),
    PAPER("보", 2); // 이처럼 생성자를 직접호출하는 경우 세미콜론을 끝에 넣어줘야 함
    
    private String name;
    private int handValue;
    
    //외부에서 생성자 호출을 못하게 private, protected로 보호한다
    private Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };
    
    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    // 여기서부터는 인스턴스 메서드
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean isStrongerThan(Hand h) {  // <Hand> isStrongerThan = h => fight(1) == 1;  이렇게 화살표 함수로 바꿀 수도 있음
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    @Override
    public String toString() {
        return name;
    }
}
