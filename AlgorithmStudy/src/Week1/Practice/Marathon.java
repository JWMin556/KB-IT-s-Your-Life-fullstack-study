package Week1.Practice;

import java.util.HashMap;
import java.util.Map;

public class Marathon {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
            int value = 1;
            if (map.containsKey(participant[i])) {
                value = map.get(participant[i]) + 1;
            }
            map.put(participant[i], value);
        }
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                if (map.get(completion[i]) == 1) {
                    map.remove(completion[i]);
                } else {
                    map.put(completion[i], map.get(completion[i]) - 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer = entry.getKey();
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }
}
