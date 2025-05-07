package ch16.practice.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private static List<Goods> giftPool = Arrays.asList(
        new Goods("메타몽 쿠션", "분홍", false),
        new Goods("메타몽 키링", "파랑", false),
        new Goods("메타몽 텀블러", "보라", true),
        new Goods("메타몽 노트북 파우치", "회색", true),
        new Goods("메타몽 인형", "분홍", false),
        new Goods("메타몽 가방", "회색", true)
    );

    public static List<Goods> pickGifts(List<Goods> pool) {
        Random rand = new Random();
        List<Goods> gifts = new ArrayList<>(pool);
        List<Goods> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index = rand.nextInt(giftPool.size());
            result.add(gifts.remove(index));
        }
        return result;
    }

    public static void printResult(String user, List<Goods> picks, Predicate<Goods> condition, String successMsg, String failMsg) {
        System.out.println("[" + user + "의  뽑기 결과]");
        for (Goods goods : picks) {
            System.out.println("-" + goods);
        }

        boolean success = picks.stream().anyMatch(condition);
        System.out.println("→ " + (success ? successMsg : failMsg));
    }

    public static void main(String[] args) {
        //supplier를 통해 객체를 리턴한다
        Supplier<List<Goods>> pickGifts  = () -> pickGifts(new ArrayList<>(giftPool));

        List<Goods> issulPicks = pickGifts.get();
        printResult("이슬이", issulPicks, g-> g.getColor().equals("분홍"), "성공! 분홍색 굿즈를 얻었어요! 🎉", "실패! 분홍색 굿즈가 없어요 😢");

        List<Goods> jiwooPicks = pickGifts.get();
        printResult("지우", jiwooPicks, Goods::isUseful, "성공! 유용한 굿즈를 얻었어요! \uD83D\uDC4D", "A실패! 유용한 굿즈가 없어요 \uD83D\uDE22");
    }
}
