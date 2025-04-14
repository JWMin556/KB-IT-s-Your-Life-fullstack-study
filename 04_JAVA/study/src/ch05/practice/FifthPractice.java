package ch05.practice;

import java.util.Scanner;

public class FifthPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int[] scores = null;
        while (run) {
            System.out.println("------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------------------------");
            System.out.print("선택> ");
            String strNum = sc.nextLine();
            if (strNum.equals("1")) {
                System.out.print("학생수> ");
                String strStudentCount = sc.nextLine();
                scores = new int[Integer.parseInt(strStudentCount)];
            } else if (strNum.equals("2")) {
                if (scores.length == 0) {
                    System.out.println("학생수를 먼저 입력해줘!");
                } else {
                    for (int i = 0; i < scores.length; i++) {
                        System.out.print("scores[" + i + "]>");
                        String scoreStr = sc.nextLine();
                        scores[i] = Integer.parseInt(scoreStr);
                    }
                }
            } else if (strNum.equals("3")) {
                for (int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]:" + scores[i]);
                }
            } else if (strNum.equals("4")) {
                int max = 0;
                int sum = 0;
                double avg = 0;
                for (int i = 0; i < scores.length; i++) {
                    sum += scores[i];
                    if (scores[i] > max) {
                        max = scores[i];
                    }
                }
                avg = sum / scores.length;
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);
            } else if (strNum.equals("5")) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
}
