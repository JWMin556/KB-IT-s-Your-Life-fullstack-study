package Week4.Practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PowerGridSplit {
    
    // BFS를 사용해서 해당 트리의 노드개수를 반환
    private static int countNodesBFS(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 모든 간선을 하나씩 끊어가면서 비교한다
        for (int i = 0; i < wires.length; i++) {
            // 트리를 초기화
            List<List<Integer>> tree = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                // 1부터 n까지 노드를 쓰기 위해 n+1개의 빈 리스트를 만든다.
                tree.add(new ArrayList<>());
            }

            // i번째 간선을 끊고 나머지 간선으로 트리 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];
                tree.get(a).add(b);
                tree.get(b).add(a);
            }

            // 아무 정점에서 BFS를 수행해 한쪽 트리의 노드 개수 구하기
            int count = countNodesBFS(tree, n, wires[i][0]);

            int diff = Math.abs(count - (n - count)); // 나머지 트리는 n - count
            answer = Math.min(answer, diff);  // 어떤 간선을 잘랐을 때, 가장 작은지 판단한다.
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] wires2 = {{1,2},{2,3},{3,4}};
        int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        System.out.println(solution(9, wires1));
        System.out.println(solution(4, wires2));
        System.out.println(solution(7, wires3));
    }
}
