package Week5.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerGridSplitDFS {
    static int answer;

    private static int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n) {
        int count = 1;
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(graph, visited, next, n);
            }
        }
        //✅ 최적값을 업데이트한다.
        answer = Math.min(answer, Math.abs(n - count * 2));  //끊었을 때 송전탑 개수 차이 계산
        // count = 현재 노드를 루트로 하는 서브트리의 노드의 수
        // 만약 한쪽을 끊으면, 한쪽은 count , 다른 한쪽은 n - count -> 그렇기에 Math.abs(n - 2*count)로 둘의 차이를 구해서
        // answer = Math.min(answer, 위 계산)을 통해 최소의 값을 찾아나선다.

        //✅ 자신 아래의 노드 수를 재귀적으로 반환한다.
        return count;
    }

    public static int solution(int n, int[][] wires) {
        answer = n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        //✅ DFS 탐색을 수행하며 답을 구한다.
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);

        return answer;
    }

    public static void main(String[] args) {
        int n= 9;
        int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        System.out.println(solution(n, wires));
    }
}
