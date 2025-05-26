package MultiCampus;

import java.util.*;

public class Test2 {
    public static int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];    // 기본 시간
        int basicFee = fees[1];     // 기본 요금
        int unitTime = fees[2];     // 단위 시간
        int unitFee = fees[3];      // 단위 요금

        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            int minutes = timeToMinutes(timeStr);

            if (action.equals("IN")) {
                inTimeMap.put(carNumber, minutes);
            } else if (action.equals("OUT")) {
                int inTime = inTimeMap.remove(carNumber);
                int duration = minutes - inTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + duration);
            }
        }

        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            int duration = timeToMinutes("23:59") - inTime;
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + duration);
        }

        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            int totalTime = totalTimeMap.get(carNumbers.get(i));
            int fee = basicFee;
            if (totalTime > basicTime) {
                fee += (int)Math.ceil((double)(totalTime - basicTime) / unitTime) * unitFee;
            }
            answer[i] = fee;
        }

        return answer;
    }

    private static int timeToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        int[] result = solution(fees, records);
        System.out.println(Arrays.toString(result));
    }
}
