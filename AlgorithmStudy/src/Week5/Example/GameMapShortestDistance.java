package Week5.Example;

import java.util.ArrayDeque;
import java.util.Queue;

public class GameMapShortestDistance {
    public static int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;

        // 큐를 준비한다
        Queue<int[]> queue = new ArrayDeque<>();
        // visited를 준비하며 모두 false로 셋팅한다
        boolean visited[][] = new boolean[n][m];

        // 큐에 시작점넣고 visitied true
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        // 상하좌우 움직임을 위한 배열 2개 셋팅
        int[] next1 = {-1, 0, 1, 0};
        int[] next2 = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int r = currentNode[0];
            int c = currentNode[1];
            int d = currentNode[2];

            if (r == n-1 && c == m-1) {
                answer = currentNode[2];
                break;
            }

            for (int i=0; i<4; i++) { //상하좌우로 움직
                int nextR = r + next1[i];
                int nextC = c + next2[i];

                // 먼저 그래프의 사정범위 안인지 파악
                if (nextR >= 0 && nextR <= n-1 && nextC >= 0 && nextC <= m-1) {
                    if (maps[nextR][nextC] == 1) { // 그 놈이 유효한지 확인
                        if (!visited[nextR][nextC]) { // 방문안했으면
                            queue.add(new int[] {nextR, nextC, d + 1});
                            visited[nextR][nextC] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
