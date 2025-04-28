package Week2.Practice;

import java.util.*;

public class ChangeWord {
    static Map<String , List<String>> graph = new HashMap<>();
    static HashSet<String> makedNode = new HashSet<>();
    static HashSet<String> visited = new HashSet<>();

    // 두 단어 중 하나의 문자만 다른지를 비교한다.
    public static boolean isOneCharDifferent(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }

    public static void makeGraph(String begin, String target, String[] words) {
        List<String> allWords = new ArrayList<>(Arrays.asList(words));
        allWords.add(begin);

        for (String word1 : allWords) {
            List<String> neighbours = new ArrayList<>();
            for (String word2 : allWords) {
                if (!word1.equals(word2) && isOneCharDifferent(word1, word2)) {
                    neighbours.add(word2);
                }
            }
            graph.put(word1, neighbours);
        }
    }

    public static int BFS(String begin, String target) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.add(begin);
        visited.add(begin);
        distance.put(begin, 0);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            if (currentNode.equals(target)) {
                return distance.get(currentNode);
            }

            for (String neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(currentNode) + 1);
                    queue.add(neighbor);
                }
            }
        }
        return 0;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target)) {
            answer = 0;
        } else {
            graph.clear();
            visited.clear();

            makeGraph(begin, target, words);
            answer = BFS(begin, target);
        }
        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }
}
