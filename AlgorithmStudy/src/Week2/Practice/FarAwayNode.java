package Week2.Practice;

import java.util.*;

public class FarAwayNode {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();
    static Map<Integer, Integer> distance = new HashMap<>();

    public static void makeGraph(int[][] edge) {
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : graph.get(node)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                    distance.put(neighbour, distance.get(node) + 1); //해당 부모노드에서의 거리 +1이면 됨
                }
            }
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        makeGraph(edge);
        BFS(1);

        int maxDist = Collections.max(distance.values());
        for (int dist : distance.values()) {
            if (dist == maxDist) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4},{5,2}};
        System.out.println(solution(6, edge));
    }
}
