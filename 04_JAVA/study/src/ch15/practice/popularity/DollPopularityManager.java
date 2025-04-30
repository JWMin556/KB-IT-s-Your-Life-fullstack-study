package ch15.practice.popularity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DollPopularityManager {
    private Map<String, Integer> countMap = new HashMap<>();

    public void addDoll(String dollName) {
        countMap.put(dollName, countMap.getOrDefault(dollName, 0) + 1);
    }

    public void showRanking() {
        System.out.println("\uD83D\uDD25 인형별 인기 순위 (많이 뽑힌 순):");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((e1, e2) -> {
            int countCompare = Integer.compare(e2.getValue(), e1.getValue());  //횟수 내림 차순
            if (countCompare == 0) {
                return e1.getKey().compareTo(e2.getKey());  // 이름 오름차순
            }
            return countCompare;
        });

        int rank = 1;
        if (list.size() > 0) {
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(rank + ". " + entry.getKey() + " - " + entry.getValue() + "회");
                rank++;
            }
        } else {
            System.out.println("\uD83D\uDCCA 아직 뽑힌 인형이 없습니다.");
        }
    }
}
