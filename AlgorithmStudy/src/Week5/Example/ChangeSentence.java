package Week5.Example;

import java.util.*;

public class ChangeSentence {
    static Map<String, List<String>> sentences = new HashMap<>(); // 그래프를 여기에 보관

    // 두 단어가 딱 한글자만 다른지 체크한다. (두 단어의 길이는 무조건 같다)
    public static boolean isDifferenceOneWord(String word1, String word2) {
        int len1 = word1.length();
        int count = 0;
        for (int i = 0; i < len1; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count == len1 - 1; // 한글자만 달라야 true반환한다.
    }

    public static void makeGraph(String begin, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(begin);
        for (String word : words) {
            list.add(word);
        }

        for (int i = 0; i < list.size(); i++) {
            String word1 = list.get(i);
            List<String> listLittle = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                String word2 = list.get(j);
                if (isDifferenceOneWord(word1, word2)) {
                    listLittle.add(word2);
                }
            }
            sentences.put(word1, listLittle);
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        makeGraph(begin, words);

        // BFS코드 시작
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);

        Map<String, Integer> distances = new HashMap<>();
        distances.put(begin, 0);
        for (String word : words) { distances.put(word, 0); }
        distances.put(target, 0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();

            if (currentWord.equals(target)) {
                answer = distances.get(currentWord);
                break;
            }

            for (String nextWord : sentences.get(currentWord)) {
                if (distances.get(nextWord) == 0) { // 방문하지 않은 노드니까 추가한다.
                    queue.add(nextWord);
                    distances.put(nextWord, distances.get(currentWord) + 1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words));
//        System.out.println(solution("hit", "hhh", new String[] {"hhh", "hht"}));
    }
}
