package Week2.Practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DevelopFeature {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new ArrayDeque<>();  // 각 일별로 며칠 내에 끝낼 수 있는지 큐에 저장
        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int remainingTime = 0;
            if ((100 - progress) % speed == 0) {
                remainingTime = (100 - progress) / speed;
            } else {
                remainingTime = ((100 - progress) / speed) + 1;
            }
            queue.add(remainingTime);
        }

        int theBiggestRemaining = queue.isEmpty() ? 0 : queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current > theBiggestRemaining) {
                finalList.add(count);
                theBiggestRemaining = current;
                count = 1;
            } else {
                count++;
            }
        }
        finalList.add(count);  // 최종적으로 확인한 count도 넣어줘야 하므로 이렇게 마지막에 넣어줌
        answer = finalList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        int[] answer = solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
