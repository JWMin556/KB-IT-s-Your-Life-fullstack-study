package Week5.Example;

import java.util.*;

public class PowerGridSplit {
    private static int countNodesBFS(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
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

        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> tree = new ArrayList<>();
            for (int j =0; j <= n; j++) {
                // 1~n까지의 노드를 쓰기 위해 n+1개의 빈 리스트 생성
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

            // 아무 정점에서 BFS를 수행해 한쪽 트리의 노드 개수 구함
            int count = countNodesBFS(tree, n, wires[i][0]);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n= 9;
        int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};

//        int n = 4;
//        int[][] wires = {{1,2}, {2,3}, {3,4}};
//
//        int n = 7;
//        int[][] wires = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};

        System.out.println(solution(n, wires));
    }
}
