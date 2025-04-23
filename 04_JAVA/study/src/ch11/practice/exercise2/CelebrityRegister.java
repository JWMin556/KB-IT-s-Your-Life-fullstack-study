package ch11.practice.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CelebrityRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Celebrity> maleList = new ArrayList<>();
        List<Celebrity> femaleList = new ArrayList<>();

        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int maleCount = Integer.parseInt(sc.nextLine());

        while(maleList.size() < maleCount){
            System.out.print("이름 입력: ");
            String maleName = sc.nextLine();
            try {
                Celebrity male = new MaleCelebrity(maleName);
                if (!maleList.contains(male)){
                    maleList.add(male);
                } else {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                }
            } catch (InvalidNameException e) {
                System.out.println(">>" + e.getMessage());
            }
        }

        System.out.print("여자 연예인 몇 명 등록할까요? ");
        int femaleCount = Integer.parseInt(sc.nextLine());

        while(femaleList.size() < femaleCount){
            System.out.print("이름 입력: ");
            String femaleName = sc.nextLine();
            try {
                Celebrity female = new FemaleCelebrity(femaleName);
                if (!femaleList.contains(female)){
                    femaleList.add(female);
                } else {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                }
            } catch (InvalidNameException e) {
                System.out.println(">>" + e.getMessage());
            }
        }

        System.out.println("\n[남자 연예인 리스트]");
        for (Celebrity male : maleList){
            System.out.println(male);
        }
        System.out.println("\n[여자 연예인 리스트]");
        for (Celebrity female : femaleList){
            System.out.println(female);
        }
    }
}
