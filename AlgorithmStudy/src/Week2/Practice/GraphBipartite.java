package Week2.Practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class GraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];  // 0: 미방문, 1과 -1 두 가지 색상으로 판별할 것이다
        for (int i = 0; i < n; i++) {
            colors[i] = 0;  // 0으로 초기화
        }

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            colors[i] = 1;  // 첫 색을 1로 시작한다.

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : graph[current]) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[current];  // 다른 색으로 칠함
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[current]) {
                         return false;  // 인접 노드가 같은 색이면 이분 그래프 아님
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph1));

        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph2));
    }
}
