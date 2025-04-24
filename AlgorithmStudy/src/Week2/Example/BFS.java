package Week2.Example;

import java.util.*;

public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        // 시작점
        Queue<Integer> queue = new ArrayDeque<>();
        // 그리고 방문  여부를 위한 HashSet필요 (혹은 배열도 가능)
        Set<Integer> visited = new HashSet<>();
        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int currentVertex = queue.poll();
            // 다음 노드 예약 -> 현재 노드와 연결된 노드들을 꺼낸다
            for (int neighbor : graph.get(currentVertex)) {
                if (!visited.contains(neighbor)) { //기존에 방문하지 않았다면
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }

    public static void main(String[] args) {
        (new BFS()).solve(makeGraph());
    }
}
