package Week7.Practice;

public class TargetNumber {
    static int answer = 0;

    public static void makeTargetNumber(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        makeTargetNumber(numbers, target, depth + 1, sum + numbers[depth]);
        makeTargetNumber(numbers, target, depth + 1, sum - numbers[depth]);
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        makeTargetNumber(numbers, target, 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
