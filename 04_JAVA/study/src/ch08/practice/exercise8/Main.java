package ch08.practice.exercise8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentManager manager = new PaymentManager();
        while (true) {
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드\n[2] 카카오페이\n[0] 종료");
            System.out.print("결제 수단을 선택하세요:");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            Payment payment = null;
            if (choice == 1) {
                payment = new CreditCard();
            } else if (choice == 2) {
                payment = new KakaoPay();
                System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
                System.out.print(">>");
                String answer = input.next();
                if (answer.equals("y")) {
                    KakaoPay kakaoPay = (KakaoPay) payment;
                    kakaoPay.authenticate();
                }
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("잘못입력했어");
            }

            if (payment.beforePay()) {
                System.out.print("결제 금액을 입력하세요: ");
                Scanner scanner = new Scanner(System.in);
                int amount = scanner.nextInt();
                manager.process(payment, amount);
            } else {
                System.out.println("[결제 실패: 준비 단계에서 중단]");
            }
            System.out.println();
        }

        manager.printSummary();
    }
}
