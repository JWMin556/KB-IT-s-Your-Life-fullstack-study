package ch04.practice;

public class FirstPractice {
    public static void main(String[] args) {
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                answer += i;
            }
        }
        System.out.println(answer);
    }
}
