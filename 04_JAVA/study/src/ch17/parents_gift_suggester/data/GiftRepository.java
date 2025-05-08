package ch17.parents_gift_suggester.data;

import ch17.parents_gift_suggester.model.GiftItem;

import java.util.List;

public class GiftRepository {
    public static List<GiftItem> getGifts() {
        return List.of(
                new GiftItem("홍삼진액", "건강식품", 120000, 85, true, false),
                new GiftItem("무릎안마기", "전자기기", 150000, 92, false, true),
                new GiftItem("꽃다발", "꽃", 30000, 65, true, true),
                new GiftItem("고급 캐시미어 머플러", "의류", 90000, 75, true, false),
                new GiftItem("손편지", "기타", 0, 95, true, true),
                new GiftItem("비타민C", "건강식품", 25000, 72, true, false)
        );
    }
}
