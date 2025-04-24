package ch11.practice.exercise34567;

import ch11.practice.exercise2.FemaleCelebrity;
import ch11.practice.exercise2.InvalidNameException;
import ch11.practice.exercise2.MaleCelebrity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException {
        MaleCelebrity[] maleCelebs  = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인"),
                new MaleCelebrity("이도현"),
                new MaleCelebrity("송강"),
                new MaleCelebrity("김선호"),
                new MaleCelebrity("안효섭"),
                new MaleCelebrity("도경수"),
                new MaleCelebrity("임시완"),
                new MaleCelebrity("이준호"),
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영"),
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("윈터"),
                new FemaleCelebrity("한소희"),
                new FemaleCelebrity("윤아"),
                new FemaleCelebrity("사쿠라"),
                new FemaleCelebrity("김세정"),
                new FemaleCelebrity("설현"),
                new FemaleCelebrity("제니"),
                new FemaleCelebrity("지수"),
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 이상형 월드컵 ===");
        System.out.println("1. 남자 연예인 월드컵");
        System.out.println("2. 여자 연예인 월드컵");
        System.out.print("경기를 선택하세요: ");
        String choice = sc.nextLine();
        try {
            CheckGender gender = new CheckGender(choice);
            if (gender.getGender() == 1) {
                MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                maleGame.printCandidates();
                System.out.println("[셔플 후 참가자 명단]");
                maleGame.shuffle();
                maleGame.printCandidates();
                maleGame.playGame();
            } else if (gender.getGender() == 2) {
                FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                femaleGame.printCandidates();
                System.out.println("[셔플 후 참가자 명단]");
                femaleGame.shuffle();
                femaleGame.printCandidates();
                femaleGame.playGame();
            }
        } catch (InvalidGenderException e) {
            System.out.println(">>" + e.getMessage());
        }
    }
}
