package ch16.practice.ex5;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

public class Main {
    public static void printInt(List<Goods> goodsList, ToIntFunction<Goods> function) {
        for (Goods goods : goodsList) {
            System.out.println("-" + goods.getName() + ": " + function.applyAsInt(goods) + "원");
        }
    }

    public static int totalPrice(List<Goods> goodsList, IntBinaryOperator operator) {
        int totalPrice = 0;
        for (Goods goods : goodsList) {
            totalPrice = operator.applyAsInt(totalPrice, goods.getDiscountedPrice());
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        List<Goods> issulGoodsList = Arrays.asList(
                new Goods("메타몽 쿠션", 20000, 0.1),
                new Goods("메타몽 키링", 8000, 0.05),
                new Goods("메타몽 인형", 15000, 0.2)
        );
        List<Goods> jiwooGoodsList = Arrays.asList(
                new Goods("메타몽 노트북 파우치", 30000, 0.2),
                new Goods("메타몽 가방", 40000, 0.2)
        );

        System.out.println("[이슬이의 장바구니]");
        printInt(issulGoodsList, t -> t.getDiscountedPrice());
        int issuleTotalPrice = totalPrice(issulGoodsList, (a , b) -> a + b);
        System.out.println("총합: " + issuleTotalPrice + "원");

        System.out.println();

        System.out.println("[지우의 장바구니]");
        printInt(jiwooGoodsList, t -> t.getDiscountedPrice());
        int jiwooTotalPrice = totalPrice(jiwooGoodsList, (a , b) -> a + b);
        System.out.println("총합: " + jiwooTotalPrice + "원");
    }
}
