package ch17.parents_gift_suggester.step6;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategorySummaryReport {
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        Map<String, List<GiftItem>> giftMap = gifts.stream().collect(Collectors.groupingBy(GiftItem::getCategory));

        DecimalFormat dfPrice = new DecimalFormat("₩#,###원");

        System.out.println("""
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                📦 카테고리별 선물 요약 리포트
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);

        for (Map.Entry<String, List<GiftItem>> entry : giftMap.entrySet()) {
            System.out.println("[" + entry.getKey() + "]");
            List<GiftItem> categoryGifts = entry.getValue();
            int allCount = categoryGifts.size();
            double averagePrice = categoryGifts.stream().mapToDouble(GiftItem::getPrice).average().getAsDouble();
            int minPrice = categoryGifts.stream().mapToInt(GiftItem::getPrice).min().getAsInt();
            int maxPrice = categoryGifts.stream().mapToInt(GiftItem::getPrice).max().getAsInt();

            System.out.println("  - 총 개수     : " + allCount + "개");
            System.out.println("  - 평균 가격   : " + dfPrice.format(averagePrice));
            System.out.println("  - 최고가      : " + dfPrice.format(maxPrice));
            System.out.println("  - 최저가      : " + dfPrice.format(minPrice));
        }


        System.out.println("""
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                리포트 생성 완료 ✅
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);
    }
}
