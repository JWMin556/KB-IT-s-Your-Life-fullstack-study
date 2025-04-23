package ch11.practice.exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("참가자 이름을 입력하세요: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        try {
            CheckName cn = new CheckName(input);
        } catch (InvalidNameException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
