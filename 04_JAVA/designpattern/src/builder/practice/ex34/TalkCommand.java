package builder.practice.ex34;

import java.util.Scanner;

public class TalkCommand implements Command {
    private DatingCharacter talkCharacter;

    public TalkCommand(DatingCharacter talkCharacter) {
        this.talkCharacter = talkCharacter;
    }

    @Override
    public void execute() {
        if (talkCharacter.getTalkStyle().contains("반말")) {
            System.out.println("[" + talkCharacter.getName() + "]" + " 뭐야~ 왜 이제 왔어?");
        } else if (talkCharacter.getTalkStyle().contains("공손")) {
            System.out.println("[" + talkCharacter.getName() + "]" + " 오셨군요. 기다리고 있었어요.");
        } else if (talkCharacter.getTalkStyle().contains("시크")) {
            System.out.println("[" + talkCharacter.getName() + "]" + " 왔네.");
        } else {
            System.out.println("[" + talkCharacter.getName() + "]" + " 안녕.");
        }

        System.out.println("""
                👉 무엇을 말할까요?
                1. 오늘 좀 바빴어
                2. 보고 싶었어
                3. 아무 말도 하지 않는다
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("[" + talkCharacter.getName() + "] " + "흐응~ 바빴구나. 알겠어.");
        } else if (choice == 2) {
            System.out.println("[" + talkCharacter.getName() + "] " + "진짜? 그 말 또 해줘 \uD83D\uDE0A");
        } else if (choice == 3) {
            System.out.println("[" + talkCharacter.getName() + "] " + "... (가만히 쳐다본다)");
        } else {
            System.out.println("[" + talkCharacter.getName() + "] " + "응? 무슨 말이야?");
        }
    }
}
