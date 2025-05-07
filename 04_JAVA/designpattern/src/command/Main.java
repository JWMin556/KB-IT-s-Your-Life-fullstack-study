package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();

        // 다형성이다. 선언은 Command 하나지만 인스턴스에 따라 다르게 동작한다. 
        Command[] commands = {
//                new AddCommend(),
                () -> System.out.println("Add Command"),
//                new OpenCommand(),
//                new PrintCommand(),
                fs::open,  // () -> fs.open()
                fs::print, // () -> fs.print()
//                new ExitCommand()
                Main::exit  // () -> Main.exit()랑 같다
        };

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit"); // 이것 때문에 배열 사용
            System.out.print("선택: ");
            int sel = scanner.nextInt();

            commands[sel - 1].execute();   // 다중 if문 없이 무엇을 선택하든 이렇게 한줄로 Main에서 처리한다. 즉, 명령어에 변화가 없다. -> OCP준수
        }
    }

    // command 인터페이스에 준하는 메서드이다. 그렇기에 메서드명은 관련없다.
    public static void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("종료할까요?(Y/n) ");
        // 대문자가 디폴트 입력 -> 즉, 그냥 엔터쳤을 때 yes로 간주한다는 것이다. 이게 관례임
        String answer = scanner.nextLine();

        scanner.close();
        // answer에 그냥 엔터쳤거나 equalsIgnoreCase를 통해 대소문자 구분하지 않고 구분한다는 것이다.
        if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
            System.exit(0); // 강제 종료
            // exit의 매개변수가 종료 상태코드이다. 0은 정상적인 종료를 의미
            // 0이 아닌 다른 숫자면 뭔가 문제가 있다는 것이다.
        }
    }
}
