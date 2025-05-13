package builder.practice.ex34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        List<DatingCharacter> characters = new ArrayList<>();
        DatingCharacter iu = new DatingCharacter.Builder()
                .name("아이유")
                .personality("상냥하고 섬세함")
                .hobby("노래")
                .favoriteFood("삼겹살")
                .talkStyle("조용하지만 유쾌함")
                .typeCode("S")
                .build();
        characters.add(iu);

        DatingCharacter suzy = new DatingCharacter.Builder()
                .name("수지")
                .personality("밝고 활발함")
                .hobby("사진 찍기")
                .favoriteFood("피자")
                .talkStyle("명랑하고 솔직함")
                .typeCode("S")
                .build();
        characters.add(suzy);

        DatingCharacter yuna = new DatingCharacter.Builder()
                .name("유나")
                .personality("쿨하고 직설적임")
                .hobby("운동")
                .favoriteFood("샐러드")
                .talkStyle("직설적이고 시원시원함")
                .typeCode("T")
                .build();
        characters.add(yuna);

        DatingCharacter nayeon = new DatingCharacter.Builder()
                .name("나연")
                .personality("장난기 많고 사교적임")
                .hobby("예능 보기")
                .favoriteFood("치킨")
                .talkStyle("장난스럽고 쾌활함")
                .typeCode("C")
                .build();
        characters.add(nayeon);

        DatingCharacter solar = new DatingCharacter.Builder()
                .name("솔라")
                .personality("카리스마 있고 자신감 있음")
                .hobby("공연")
                .favoriteFood("김치찌개")
                .talkStyle("자신감 넘치고 당당함")
                .typeCode("C")
                .build();
        characters.add(solar);

        DatingCharacter sejeong = new DatingCharacter.Builder()
                .name("세정")
                .personality("긍정적이고 다정함")
                .hobby("글쓰기")
                .favoriteFood("빙수")
                .talkStyle("따뜻하고 유쾌함")
                .typeCode("T")
                .build();
        characters.add(sejeong);

        DatingCharacter somi = new DatingCharacter.Builder()
                .name("소미")
                .personality("에너지 넘치고 자유로움")
                .hobby("댄스")
                .favoriteFood("햄버거")
                .talkStyle("자유롭고 유쾌함")
                .typeCode("S")
                .build();
        characters.add(somi);

        DatingCharacter karina = new DatingCharacter.Builder()
                .name("카리나")
                .personality("차분하고 신중함")
                .hobby("명상")
                .favoriteFood("스시")
                .talkStyle("조용하고 단정함")
                .typeCode("T")
                .build();
        characters.add(karina);

        System.out.println("""
                💘 어떤 유형의 캐릭터를 보고 싶나요?
                → S (순수형), T (츤데레형), C (차도남/차도녀형)
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.print("입력: ");
        String input = scanner.nextLine();
        List<DatingCharacter> selectedCharacters = characters.stream()
                .filter(c -> input.equalsIgnoreCase(c.getTypeCode()))
                .toList();

        System.out.println("[해당 유형 캐릭터 목록]");
        int index = 1;
        for (DatingCharacter character : selectedCharacters) {
            System.out.print(index + ". ");
            System.out.println(character.toString());
            index++;
        }
    }
}
