package ch17.parents_gift_suggester.step1;

import ch17.parents_gift_suggester.data.GiftRepository;
import ch17.parents_gift_suggester.model.GiftItem;

import java.util.List;

public class HighPreferenceFilter {
    public static void run() {
        List<GiftItem> gifts = GiftRepository.getGifts();
        System.out.println("\uD83C\uDF81 부모님이 진짜 좋아하시는 선물 리스트");
        gifts.stream().filter(g -> g.getPreferenceScore() >= 70).forEach(name -> System.out.println(name.getName()));
    }
}
