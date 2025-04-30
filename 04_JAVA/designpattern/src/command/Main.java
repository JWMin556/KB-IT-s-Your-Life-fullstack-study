package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 다형성이다. 선언은 Command 하나지만 인스턴스에 따라 다르게 동작한다. 
        Command[] commands = {
                new AddCommend(),
                new OpenCommand(),
                new PrintCommand(),
                new ExitCommand()
        };

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit"); // 이것 때문에 배열 사용
            System.out.print("선택: ");
            int sel = scanner.nextInt();

            commands[sel - 1].execute();   // 다중 if문 없이 무엇을 선택하든 이렇게 한줄로 Main에서 처리한다. 즉, 명령어에 변화가 없다. -> OCP준수
        }
    }
}
