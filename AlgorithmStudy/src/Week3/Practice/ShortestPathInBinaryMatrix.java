package Week3.Practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static boolean isValid(int currRow, int currCol, int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        return 0<=currRow && currRow < rowLength && 0<=currCol && currCol < colLength && grid[currRow][currCol] == 0;
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        if (!isValid(0, 0, grid)) {
            return -1;
        } else {
            queue.offer(new int[]{0, 0});
            distance[0][0] = 1;

            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int currRow = node[0];
                int currCol = node[1];
                for (int d = 0; d < dr.length; d++) {
                    int nextRow = currRow + dr[d];
                    int nextCol = currCol + dc[d];
                    if (isValid(nextRow, nextCol, grid)) {
                        if (distance[nextRow][nextCol] == -1) {
                            queue.offer(new int[]{nextRow, nextCol});
                            distance[nextRow][nextCol] = distance[currRow][currCol] + 1;
                        }
                    }
                }
            }
        }
        return distance[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
//        {{0,1}, {1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
