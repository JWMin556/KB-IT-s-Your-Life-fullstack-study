package builder.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatingCharacterTest {
    public static void main(String[] args) {
        List<DatingCharacter> characters = new ArrayList<>();

        DatingCharacter jimin = new DatingCharacter.Builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .hobby("춤")
                .favoriteFood("떡볶이")
                .talkStyle("부드럽고 공손함")
                .build();

        DatingCharacter jenny = new DatingCharacter.Builder()
                .name("제니")
                .personality("도도하지만 배려심 있음")
                .hobby("여행")
                .favoriteFood("파스타")
                .talkStyle("털털한 반말")
                .build();

        DatingCharacter taeyoun = new DatingCharacter.Builder()
                .name("태연")
                .personality("조용하지만 리더십 있음")
                .hobby("독서")
                .favoriteFood("마라탕")
                .talkStyle("단호하지만 상냥함")
                .build();

        characters.add(jimin);
        characters.add(jenny);
        characters.add(taeyoun);

        Collections.sort(characters);
        System.out.println("[이상형 캐릭터 목록]");
        for (DatingCharacter character : characters) {
            System.out.println(character);
        }
    }
}
