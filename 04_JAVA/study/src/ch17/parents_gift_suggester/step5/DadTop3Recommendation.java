package ch17.parents_gift_suggester.step5;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class DadTop3Recommendation{
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        List<GiftItem> dadGifts = gifts.stream().filter(d -> d.isForDad()).sorted(Comparator.comparing(GiftItem::getPreferenceScore).reversed()).limit(3).toList();
        if (dadGifts.isEmpty()) {
            System.out.println("\uD83D\uDE2D 아빠를 위한 추천 선물이 없습니다.");
        } else {
            DecimalFormat dfPrice = new DecimalFormat("###,###");
            DecimalFormat dfPreference = new DecimalFormat("0.0");

            double averagePrice = dadGifts.stream().mapToInt(GiftItem::getPrice).average().orElse(0.0);
            String averagePriceString = dfPrice.format(averagePrice);

            double averagePreference = dadGifts.stream().mapToInt(GiftItem::getPreferenceScore).average().orElse(0.0);
            String averagePreferenceString = dfPreference.format(averagePreference);

            int maxPrice = dadGifts.stream().mapToInt(GiftItem::getPrice).max().orElse(0);
            int minPirce = dadGifts.stream().mapToInt(GiftItem::getPrice).min().orElse(0);

            System.out.println("\uD83C\uDF81 아빠가 좋아하실 감동 추천 Top 3");
            int count = 1;
            String moneyEmoji = null;
            for (GiftItem item : dadGifts) {
                if (item.getPrice() == maxPrice) {
                    moneyEmoji = "\uD83D\uDC8E";
                } else if (item.getPrice() == minPirce) {
                    moneyEmoji = "\uD83D\uDCB8";
                } else {
                    moneyEmoji = "";
                }
                int total = 5;
                int fillted = item.getPreferenceScore() / 20;
                int empty = total - fillted;
                String stars = "★".repeat(fillted) + "☆".repeat(empty);
                System.out.println(count + ". [" + item.getName() + "] - " + item.getCategory() + " / ₩" + dfPrice.format(item.getPrice()) + "원" + " / 선호도: " +  item.getPreferenceScore() + "점 (" + stars + ") " + moneyEmoji);
                count++;
            }

            System.out.println("\uD83D\uDCCA 평균 선호도: " + averagePreferenceString + "점");
            System.out.println("\uD83D\uDCCA 평균 가격: ₩" + averagePriceString + "원");
        }

    }
}
