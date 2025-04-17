package Week1.Practice;

import java.util.Arrays;

public class Budget {
//    public static int solution(int[] d, int budget) {
//        int answer = 0;
//        Arrays.sort(d);
//        for (int i = 0; i < d.length; i++) {
//            budget -= d[i];
//            if (budget == 0) {
//                answer = i + 1;
//                break;
//            } else if (budget < 0) {
//                answer = i;
//                break;
//            }
//        }
//        return answer;
//    }
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum <= budget) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4 };
        System.out.println(solution(d, 9));
    }
}
