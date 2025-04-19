package Week1.Advanced;

import java.util.ArrayDeque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 즉, 현재 온도가 스택의 top 인덱스의 온도보다 높을 경우
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] answer = dailyTemperatures(temp);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
