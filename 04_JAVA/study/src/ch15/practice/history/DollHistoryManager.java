package ch15.practice.history;

import java.util.*;

public class DollHistoryManager {
    private Map<String, List<String>> historyMap = new HashMap<>();
    public void addHistory(String customer, String doll) {
        historyMap.computeIfAbsent(customer, k -> new ArrayList<>()).add(doll);
        System.out.println("\uD83D\uDCD2 " + customer + " 님의 인형 기록에 '" + doll + "' 이 추가되었습니다.");
    }

    public void showAllHistory() {
        System.out.println("\uD83D\uDCCB 고객별 인형 기록:");
        Set<Map.Entry<String, List<String>>> entrySet = historyMap.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            System.out.println("-" + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void showAllUniqueHistory() {
        System.out.println("\uD83C\uDF81 중복 인형 제거 이벤트 결과:");
        for (String name : historyMap.keySet()) {
            Set<String> unique = new HashSet<>(historyMap.get(name));
            Iterator<String> iterator = unique.iterator();
            List<String> list = new ArrayList<>();
            while (iterator.hasNext()) {
                String doll = iterator.next();
                list.add(doll);
            }
            System.out.println("-" + name + ": " + list);
        }
    }
}
