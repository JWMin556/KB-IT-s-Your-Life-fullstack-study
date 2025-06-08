package Week3.Practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class KeepDistance {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static boolean bfs(String[] place, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currentX = cur[0];
            int currentY = cur[1];
            int dist =  cur[2];

            if (dist >= 1 && dist <= 2 && place[currentX].charAt(currentY) == 'P') {
                return false;
            }

            if (dist >= 2) continue;

            for (int d = 0; d < 4; d++) {
                int nextX = cur[0] + dx[d];
                int nextY = cur[1] + dy[d];

                if (nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5 &&
                    !visited[nextX][nextY] && place[nextX].charAt(nextY) != 'X') {
                    queue.add(new int[]{nextX, nextY, dist + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return true;
    }

    private static boolean checkRooms(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new  int[5];
        for (int i = 0; i < 5; i++) {
            if (checkRooms(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution = solution(places);
        System.out.println(Arrays.toString(solution));
    }
}
