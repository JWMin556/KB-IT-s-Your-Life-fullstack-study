package ch08.practice.exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = {
                new CreditCard(),
                new KakaoPay(),
                new KakaoPay(),
                new CreditCard(),
        };

        int index = 1;
        for (Payment payment : payments) {
            System.out.println("[" + index + "번 결제수단] 결제 금액을 입력하세요: ");
            System.out.print(">> ");
            Scanner scanner = new Scanner(System.in);
            int amount = scanner.nextInt();
            if (payment.pay(amount)) {
                payment.approve();
                payment.cancel("테스트 취소");
            } else {
                System.out.println("[결제 실패: 승인/취소 건너뜀]");
            }
            System.out.println();
            index++;
        }
    }
}
