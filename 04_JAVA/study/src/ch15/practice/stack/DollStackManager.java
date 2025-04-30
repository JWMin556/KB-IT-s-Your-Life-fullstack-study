package ch15.practice.stack;

import java.util.*;

public class DollStackManager {
    private String[] dolls = {
            "피카츄", "리자몽", "꼬부기", "쿠로미", "헬로키티",
            "뽀로로", "짱구", "도라에몽", "스폰지밥", "미니언"
    };
    private Deque<String> stack = new ArrayDeque<>();

    private String getRandomDoll() {
        Random random = new Random();
        return dolls[random.nextInt(dolls.length)];
    }

    public String storeRandomDoll() {
        String doll = getRandomDoll();
        stack.push(doll);
        System.out.println("\uD83E\uDDF8 " + doll + " 인형이 보관함에 추가되었습니다.");
        return doll;
    }

    public void showStack() {
        ArrayList<String> list = new ArrayList<>(stack);
        Collections.reverse(list);
        System.out.println("\uD83E\uDDF8 현재 보관 중인 인형: " + list);
    }
}
