package ch06.practice.deepening2;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);  // Scanner 객체에 대한 정적 참조 변수로 즉시 초기화
    static String read(String title) {
        System.out.print(title);
        return scanner.nextLine();
    }
    static String read(String title, String defaultValue) {
        System.out.print(title + "(" + defaultValue + "): ");
        String input = scanner.nextLine(); // 사용자 입력
        if (input.trim().isEmpty()) {
            return defaultValue;
        }
        return input;
    }
    static int readInt(String title) {
        System.out.print(title);
        return Integer.parseInt(scanner.nextLine());
    }
    static boolean confirm(String title, boolean defaultValue) {
        String prompt = title + " ";
        prompt += defaultValue ? "(Y/n): " : "(y/N): ";

        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.isEmpty()) {
            return defaultValue;
        }

        // 'y'면 true, 'n'이면 false
        if (input.equals("y")) {
            return true;
        } else if (input.equals("n")) {
            return false;
        } else {
            // 잘못된 입력 → 재귀 호출로 다시 물어보기
            System.out.println("y 또는 n으로 입력해주세요.");
            return confirm(title, defaultValue);
        }
    }

    // 기본값 없는 confirm → 기본값 true로 설정
    public static boolean confirm(String title) {
        return confirm(title, true);
    }
}
