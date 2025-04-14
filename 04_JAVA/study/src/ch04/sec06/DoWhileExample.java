package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메시지를 입력하라");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String inputString;
        do { // while문 안의 조건이 false라도 무조건 한번은 실행을 해준다. 즉, 처음 로딩되고 바로 q를 입력하면 q를 출력되고 종료
            System.out.print(">");
            inputString = sc.nextLine();
            System.out.println(inputString);
        } while (!inputString.equals("q"));  // 사용자가 q를 입력할 때까지 반복한다. 

        System.out.println();
        System.out.println("프로그램 종료");
    }
}
