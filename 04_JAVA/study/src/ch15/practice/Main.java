package ch15.practice;

import ch15.practice.history.DollHistoryManager;
import ch15.practice.popularity.DollPopularityManager;
import ch15.practice.queue.DollQueueManager;
import ch15.practice.stack.DollStackManager;
import ch15.practice.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DollQueueManager dqm = new DollQueueManager();
        DollStackManager stm = new DollStackManager();
        DollHistoryManager hm = new DollHistoryManager();
        DollPopularityManager pm = new DollPopularityManager();

        while (true) {
            System.out.println();
            System.out.println("=== 유라의 인형뽑기 가게 ===");
            System.out.println("[1] 고객 등록");
            System.out.println("[2] 뽑기 진행 (인형 보관)");
            System.out.println("[3] 현재 대기열 보기");
            System.out.println("[4] 보관함 보기");
            System.out.println("[5] 고객별 인형 기록 보기");
            System.out.println("[6] 중복 제거된 인형 목록 보기");
            System.out.println("[7] 인형별 인기 순위 보기");
            System.out.println("[0] 종료");

            Scanner scanner = new Scanner(System.in);
            System.out.print("선택 >> ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                String customer = RandomCustomerProvider.getRandomCustomer();
                dqm.registerCustomer(customer);
            } else if (choice == 2) {
                String customer = dqm.getNextCustomer();
                if (customer == null) {
                    System.out.println("⛔ 대기 중인 고객이 없습니다.");
                } else {
                    System.out.println("\uD83C\uDF89 " + customer + "님! 인형 뽑기 하러 오세요!");
                    String doll = stm.storeRandomDoll();
                    hm.addHistory(customer, doll);
                    pm.addDoll(doll);

                    System.out.print("한 번 더 뽑으시겠습니까? (y/n): ");
                    String answer = scanner.next();
                    if (answer.toLowerCase().equals("y")) {
                        dqm.registerCustomer(customer);
                        System.out.println("\uD83D\uDD01 " + customer + "님이 다시 대기열에 등록되었습니다.");
                    }
                }
            } else if (choice == 3) {
                dqm.showWaitingList();
            } else if (choice == 4) {
                stm.showStack();
            } else if (choice == 5) {
                hm.showAllHistory();
            } else if (choice == 6) {
                hm.showAllUniqueHistory();
            } else if (choice == 7) {
                pm.showRanking();
            } else if (choice == 0) {
                System.out.println("\uD83D\uDC4B 프로그램을 종료합니다.");
                break;
            }
        }
    }
}
