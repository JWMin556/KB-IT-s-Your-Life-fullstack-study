package ch02.sec13;

import java.util.Scanner;

public class ScnnerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("X값 입력: ");
        String strx = scanner.nextLine();
        int x = Integer.parseInt(strx);

        System.out.print("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("x + y = " + result);
    }
}
