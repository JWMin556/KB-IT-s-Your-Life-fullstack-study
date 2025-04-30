package command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
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
