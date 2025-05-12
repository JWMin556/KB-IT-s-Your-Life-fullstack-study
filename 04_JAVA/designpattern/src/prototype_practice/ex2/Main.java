package prototype_practice.ex2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        Map<Product, String> history = new LinkedHashMap<>();

        // 카드 템플릿 등록
        manager.register("insta", new CardTemplate("Instagram Story", '*'));
        manager.register("twit", new CardTemplate("Tweet Style", '-'));
        manager.register("short", new CardTemplate("YouTube Shorts", '#'));

        while (true) {
            manager.printRegisteredStyles();

            System.out.print("사용할 스타일 이름 입력 (종료: exit): ");
            String style = sc.nextLine().trim();

            if (style.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("출력할 문구 입력: ");
            String content = sc.nextLine().trim();

            if (!manager.isRegistered(style)) {
                System.out.println("[Error] 등록되지 않은 스타일입니다: " + style);
                System.out.println();
                continue;
            }

            Product card = manager.create(style);
            card.use(content);
            history.put(card, content);
        }

        System.out.println("\n📦 사용된 카드 목록 출력:\n");

        for(Map.Entry<Product, String> entry : history.entrySet()) {
            Product card = entry.getKey();
            String content = entry.getValue();
            card.use(content);
        }

        sc.close();
    }
}
