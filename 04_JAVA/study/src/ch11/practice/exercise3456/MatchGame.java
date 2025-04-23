package ch11.practice.exercise3456;

import ch11.practice.exercise2.Celebrity;

import java.util.Random;
import java.util.Scanner;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;
    public abstract void initializeCandidates();
    public abstract Celebrity playGame();
    public void printCandidates() {
        for (Celebrity c : candidates) {
            System.out.println(c);
        }
    }
    public void shuffle() {
        Random rand = new Random();
        for (int i = candidates.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            Celebrity temp = candidates[index];
            candidates[index] = candidates[i];
            candidates[i] = temp;
        }
    }

    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {
        Celebrity winner = null;
        System.out.println("누가 더 이상형인가요?");
        System.out.println("1. " + c1.getName());
        System.out.println("2. " + c2.getName());
        System.out.print("선택: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                winner = c1;
                break;
            } else if (choice == 2) {
                winner = c2;
                break;
            } else {
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
            }
        }
        System.out.println("[" + winner.getName() + " 승리!]");
        return winner;
    }
}
