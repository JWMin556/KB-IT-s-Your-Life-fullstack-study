package ch16.practice.ex2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static List<Goods> goodsList = Arrays.asList(
        new Goods("메타몽 쿠션", "분홍", false),
        new Goods("메타몽 노트북 파우치", "보라", true),
        new Goods("메타몽 인형", "분홍", false),
        new Goods("메타몽 가방", "회색", true),
        new Goods("메타몽 키링", "파랑", false)
    );

    public static void printSelectedGoods(String user, Predicate<Goods> filter) {
        System.out.println("[" + user + "의 선택]");
        for (Goods goods : goodsList) {
            if (filter.test(goods)) {
                System.out.println("-" + goods.getName());
            }
        }
    }

    public static void main(String[] args) {
        printSelectedGoods("이슬이", p -> p.getColor().equals("분홍"));
        System.out.println();
        printSelectedGoods("지우", p -> p.isUseful());
    }
}
