package ch17.parents_gift_suggester.step4;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;

public class MomGiftAveragePrice {
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        List<GiftItem> filtedGifts = gifts.stream().filter(g -> g.isForMom() && g.getPreferenceScore() >= 70).toList();

        System.out.println("\uD83D\uDC69 엄마 전용 선물들의 평균 가격 리포트");

        if (filtedGifts.isEmpty()) {
            System.out.println("😭 조건에 맞는 엄마 전용 선물이 아직 없습니다.");
        } else {
            double averageGiftDoublePrice = filtedGifts.stream().mapToInt(g -> g.getPrice()).average().getAsDouble();
            int averageGiftPrice = (int) averageGiftDoublePrice;
            DecimalFormat df = new DecimalFormat("#,###");
            String formattedAverageGiftPrice = df.format(averageGiftPrice);

            System.out.println("\uD83D\uDCE6 포함된 선물:");
            for (GiftItem item : filtedGifts) {
                System.out.println("- " + item.getName());
            }
            System.out.println("\uD83D\uDCCA 평균 가격: ₩" + formattedAverageGiftPrice + "원");
        }
    }
}
