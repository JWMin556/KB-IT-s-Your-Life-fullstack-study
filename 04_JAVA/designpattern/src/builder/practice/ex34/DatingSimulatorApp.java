package builder.practice.ex34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatingSimulatorApp {
    public static void main(String[] args) {
        List<DatingCharacter> characters = new ArrayList<>();
        DatingCharacter iu = new DatingCharacter.Builder()
                .name("아이유")
                .personality("다정하고 감성적임")
                .hobby("노래")
                .favoriteFood("삼겹살")
                .talkStyle("조용하지만 유쾌함")
                .typeCode("S")
                .build();
        characters.add(iu);

        DatingCharacter suzy = new DatingCharacter.Builder()
                .name("수지")
                .personality("도도하지만 배려심 있음")
                .hobby("사진 찍기")
                .favoriteFood("피자")
                .talkStyle("명랑하고 솔직함")
                .typeCode("C")
                .build();
        characters.add(suzy);

        DatingCharacter yuna = new DatingCharacter.Builder()
                .name("유나")
                .personality("무뚝뚝한 츤데레")
                .hobby("운동")
                .favoriteFood("샐러드")
                .talkStyle("직설적이고 시원시원함")
                .typeCode("T")
                .build();
        characters.add(yuna);

        System.out.println("\uD83D\uDC98 대화하고 싶은 캐릭터를 선택하세요:");
        int index = 1;
        for (DatingCharacter character : characters) {
            System.out.println(index + ". " + character.toString());
            index++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("번호 입력: ");
        int choice = scanner.nextInt();

        Command cd = new TalkCommand(characters.get(choice - 1));
        cd.execute();
    }
}
