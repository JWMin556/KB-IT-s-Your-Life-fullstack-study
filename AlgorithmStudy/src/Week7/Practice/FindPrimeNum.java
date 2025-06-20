package Week7.Practice;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum {
    public static int solution(String numbers) {
        Set<Integer> numSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        for (int r = 1; r <= numbers.length(); r++) {
            makeNumbers(numbers.toCharArray(), "", visited, r, numSet);
        }

        int count = 0;
        for (int num : numSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    // 순열을 재귀적으로 생성하는 함수
    private static void makeNumbers(char[] chars, String current, boolean[] visited, int r, Set<Integer> numSet) {
        if (current.length() == r) {
            numSet.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumbers(chars, current + chars[i], visited, r, numSet);
                visited[i] = false; // 백트래킹
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) { return false; }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { return false; }
        }
        return true;
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        System.out.println(solution("17"));   // 출력: 3
        System.out.println(solution("011"));  // 출력: 2
    }
}
