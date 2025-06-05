package Week3.Example;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ambulance {
    public static int solution(int[][] city) {
        int answer = -1;
        int[] rowDistance = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] cityDistance = {1, 1, 0, -1, -1, -1, 0, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[city.length][city[0].length];

        if (city[0][0] == 0) {
            queue.add(new int[] {0, 0, 1});  // x좌표, y좌표, 거리
            visited[0][0] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (row == city.length - 1 && col == city[0].length - 1) {
                answer = distance;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nextRow = row + rowDistance[i];
                int nextCol = col + cityDistance[i];

                if (nextRow >= 0 && nextRow < city.length && nextCol >= 0 && nextCol < city[0].length) {
                    if (city[nextRow][nextCol] == 0) {
                        if (!visited[nextRow][nextCol]) {
                            visited[nextRow][nextCol] = true;
                            queue.add(new int[] {nextRow, nextCol, distance + 1});
                        }
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] city1 = {{0, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 0, 0}};
        int[][] city2 = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}, {1, 1, 0}, {0, 0, 0}};
        int[][] city4 = {{1, 0, 0, 0}, {1, 1, 1, 0}, {1, 0, 0, 0}, {1, 1, 1, 0}};

        System.out.println(solution(city4));
    }
}
