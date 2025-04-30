package command;

import java.util.Scanner;

public class AddCommend implements Command {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1: ");
        int num1 = sc.nextInt();

        System.out.print("숫자2: ");
        int num2 = sc.nextInt();

        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
    }
}
