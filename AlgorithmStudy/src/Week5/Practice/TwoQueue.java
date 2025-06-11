package Week5.Practice;

public class TwoQueue {
    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;
        int[] total = new int[n * 2];

        for (int i = 0; i < n; i++) {
            total[i] = queue1[i];
            total[i + n] = queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;
        int left = 0;
        int right = n;
        long currentSum = sum1;
        int count = 0;

        // 최대 이동 횟수는 2 * n
        while (count <= n * 3) {
            if (currentSum == target) return count;
            else if (currentSum > target) {
                currentSum -= total[left % (2 * n)];
                left++;
            } else {
                currentSum += total[right % (2 * n)];
                right++;
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

//        int[] queue1 = {1,1};
//        int[] queue2 = {1,5};

        System.out.println(solution(queue1, queue2));
    }
}
