package ch08.practice.exercise5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 결제 수단 선택 ===");
        System.out.println("[1] 신용카드\n[2] 카카오페이");
        System.out.print("결제 수단을 선택하세요:");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        Payment payment = null;
        if (choice == 1) {
            payment = new CreditCard();
        } else if (choice == 2) {
            payment = new KakaoPay();
        } else {
            System.out.println("잘못입력함");
        }
        System.out.println("결제 금액을 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        if (payment.pay(amount)) {
            payment.approve();
            payment.cancel("테스트 취소");

            if (payment instanceof KakaoPay kakaoPay) {
                kakaoPay.sendNotification();
            } else {
                System.out.println("[알림 서비스 없음]");
            }

        } else {
            System.out.println("[결제 실패: 승인/취소 건너뜀]");
        }

    }
}
