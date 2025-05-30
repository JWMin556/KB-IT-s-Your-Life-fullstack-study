package Week3.Practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class TravelMap {
    public static int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n+1][m+1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> q = new ArrayDeque<>();
        visited[1][1][0] = true;
        q.add(new int[]{1, 1, 0, 0});

        int[] dr = {0, 1, 0, -1, 0, 2, 0, -2};
        int[] dc = {1, 0, -1, 0, 2, 0, -2, 0};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int jumped = curr[2];
            int dist = curr[3];

            for (int d = 0; d < ((jumped == 1) ? 4 : 8); d++) {
                int nextRow = r + dr[d];
                int nextCol = c + dc[d];
                int nextJumped = (jumped == 1) ? 1 : (d/4);

                if (nextRow >= 1 && nextRow <= n && nextCol >= 1 && nextCol <= m) {
                    if (!visited[nextRow][nextCol][nextJumped] && !trap[nextRow][nextCol]) {
                        visited[nextRow][nextCol][nextJumped] = true;

                        if (nextRow == n && nextCol == m) {
                            return dist + 1;
                        }

                        q.add(new int[] {nextRow, nextCol, nextJumped , dist+1});
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;

        int[][] hole = {{2,3}, {3,3}};
        System.out.println(solution(n, m, hole));
    }
}
