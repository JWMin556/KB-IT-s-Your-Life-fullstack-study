package ch11.practice.exercise3456;

import ch11.practice.exercise2.Celebrity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaleMatchGame extends MatchGame {
    private Celebrity[] inputCelebrities;
    public MaleMatchGame(Celebrity[] celebrityList) {
        this.inputCelebrities = celebrityList;
        initializeCandidates();
    }

    @Override
    public void initializeCandidates() {
        super.candidates = new Celebrity[inputCelebrities.length];
        for (int i = 0; i < inputCelebrities.length; i++) {
            super.candidates[i] = inputCelebrities[i];
        }
    }

    @Override
    public Celebrity playGame() {
        Scanner scanner = new Scanner(System.in);
        List<Celebrity> currentRound = new ArrayList<>(Arrays.asList(candidates));
        int round = 1;

        while (currentRound.size() > 1) {
            System.out.println("\n=== " + round + "라운드 ===");
            List<Celebrity> nextRound = new ArrayList<>();

            for (int i = 0; i < currentRound.size(); i += 2) {
                if (i + 1 >= currentRound.size()) {
                    // 부전승 처리
                    Celebrity winner = currentRound.get(i);
                    System.out.println(winner.getName() + "은(는) 자동으로 다음 라운드 진출!");
                    nextRound.add(winner);
                    continue;
                }

                Celebrity c1 = currentRound.get(i);
                Celebrity c2 = currentRound.get(i + 1);

                System.out.println("누가 더 이상형인가요?");
                System.out.println("1. " + c1.getName());
                System.out.println("2. " + c2.getName());
                System.out.print("선택: ");

                int choice;
                while (true) {
                    try {
                        choice = Integer.parseInt(scanner.nextLine().trim());
                        if (choice == 1 || choice == 2) break;
                    } catch (NumberFormatException ignored) {}
                    System.out.print("잘못된 입력입니다. 1 또는 2를 선택하세요: ");
                }

                Celebrity winner = (choice == 1) ? c1 : c2;
                System.out.println("[" + winner.getName() + " 승리!]");
                nextRound.add(winner);
            }

            currentRound = nextRound;
            round++;
        }

        System.out.println("\n🏆 최종 우승자: " + currentRound.get(0).getName());
        return currentRound.get(0);
    }


    @Override
    public void printCandidates() {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
