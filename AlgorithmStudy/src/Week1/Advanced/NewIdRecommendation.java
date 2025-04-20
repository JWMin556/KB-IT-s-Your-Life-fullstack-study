package Week1.Advanced;

import java.util.Locale;

public class NewIdRecommendation {
    public static String solution(String new_id) {
        String answer =  new_id.toLowerCase(Locale.ROOT);
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]&", "");
        answer = answer.isEmpty() ? "a" : answer;
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        answer = answer.replaceAll("[.]$", "");
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
