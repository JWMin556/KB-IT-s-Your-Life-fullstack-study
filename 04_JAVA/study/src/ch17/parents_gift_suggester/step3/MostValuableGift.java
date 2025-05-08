package ch17.parents_gift_suggester.step3;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MostValuableGift {
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        boolean momMode = true;

        System.out.println("\uD83D\uDC8E 부모님께 드릴 수 있는 최고의 프리미엄 선물");
        if (momMode) {
            List<GiftItem> momGifts = gifts.stream().filter(m -> m.isForMom()).toList();
            Optional<GiftItem> topGift = momGifts.stream().max(Comparator.comparing(GiftItem::getPrice));
            topGift.ifPresentOrElse(
                    m -> System.out.println("\uD83D\uDC9D [" + m.getName() + "] - " + m.getCategory() + " (₩"+ m.getPrice() + ") / 선호도: " + m.getPreferenceScore() + "점"),
                    () -> System.out.println("\uD83D\uDE22 조건에 맞는 고가의 선물을 찾지 못했어요.")
            );

        } else {
            List<GiftItem> dadGifts = gifts.stream().filter(d -> d.isForDad() && d.getPreferenceScore() >= 90).toList();
            Optional<GiftItem> topGift = dadGifts.stream().max(Comparator.comparing(GiftItem::getPrice));
            topGift.ifPresentOrElse(
                    d -> System.out.println("\uD83C\uDF81 [" + d.getName() + "] - " + d.getCategory() + " (₩"+ d.getPrice() + ") / 선호도: " + d.getPreferenceScore() + "점"),
                    () -> System.out.println("\uD83D\uDE22 조건에 맞는 고가의 선물을 찾지 못했어요.")
            );
        }
    }
}
