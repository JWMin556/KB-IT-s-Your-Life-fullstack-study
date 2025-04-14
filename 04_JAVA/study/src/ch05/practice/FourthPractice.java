package ch05.practice;

import java.util.Scanner;

public class FourthPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int money = 0;

        while (run) {
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");
            System.out.print("선택> ");
            String strNum = sc.nextLine();
            if (strNum.equals("1")) {
                System.out.print("예금액> ");
                String strMoney = sc.nextLine();
                money += Integer.parseInt(strMoney);
            } else if (strNum.equals("2")) {
                System.out.print("출금액> ");
                String outMoney = sc.nextLine();
                if (money < Integer.parseInt(outMoney)) {
                    System.out.println("잔고가 부족합니다");
                } else {
                    money -= Integer.parseInt(outMoney);
                }
            } else if (strNum.equals("3")) {
                System.out.println("잔고> " + money);
            } else if (strNum.equals("4")) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
}
