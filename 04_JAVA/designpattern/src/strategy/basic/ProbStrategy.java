package strategy.basic;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;  //직전에 무엇을 넣었는지
    private int currentHandValue = 0;  // 이번에 무엇을 넣었는지
    private int [][] history = { // 2차원 배열을 통해 [이전Hand][가위바위보]를 넣을 것이다.
            { 1, 1, 1, },
            { 1, 1, 1, },
            { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            sum += history[handvalue][i];
        }
        return sum;
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        // 확률 기반으로 정수를 결정하는 알고리즘이다.
        if(bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if(bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            //이겼다면, prevHandValue의 currentHandValue만 1증가
            history[prevHandValue][currentHandValue]++;
        } else {
            // 졌다면, 다른 Hand에 대해서 1증가
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
