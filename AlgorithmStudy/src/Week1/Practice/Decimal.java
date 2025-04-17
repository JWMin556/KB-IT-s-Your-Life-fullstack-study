package Week1.Practice;

import java.util.Arrays;

public class Decimal {
    public static boolean eratosthenes(int n) {
        if (n < 2) {
            return false;
        }

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            // i의 루트n으로 하는게 더 효율적이다. 그 이유는 앞까지만 보아도 결과를 알 수 있기 때문이다.
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[n];
    }
    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int prineNumber = nums[i] + nums[j] + nums[k];
                    if (eratosthenes(prineNumber)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }
}
