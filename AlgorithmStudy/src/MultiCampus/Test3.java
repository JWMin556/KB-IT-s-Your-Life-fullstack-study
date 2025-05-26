package MultiCampus;

import java.util.*;

public class Test3 {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < computers.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    list.add(j);
                }
            }
            graph.put(i, list);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                queue.add(i);
                visited.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (Integer neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(3, computers));
    }
}
