package ch17.parents_gift_suggester.step2;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryCountReport {
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        Map<String, Long> categotyCounts = gifts.stream().collect(Collectors.groupingBy(GiftItem::getCategory, Collectors.counting()));
        Map<String, Long> categoryCounts2 = gifts.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.getCategory(),
                                Collectors.counting()
                        ));

        System.out.println("\uD83D\uDCE6 카테고리별 선물 개수 요약");
        for (Map.Entry<String, Long> entry : categoryCounts2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "개");
        }
    }
}
