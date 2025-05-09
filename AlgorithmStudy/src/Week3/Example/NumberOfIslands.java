package Week3.Example;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    static boolean[][] visited;
    static int[][] intGrid;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int rowLength;
    static int colLength;

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < rowLength && col >= 0 && col < colLength && intGrid[row][col] == 1;
    }

    public static void bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        intGrid[row][col] = 0;  // 훗날 네트워크의 개수를 파악하기 위해서

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int k = 0; k < 4; k++) {
                int newRow = curRow + dr[k];
                int newCol = curCol + dc[k];
                if (isValid(newRow, newCol)) {
                    if (!visited[newRow][newCol]) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                        intGrid[newRow][newCol] = 0;
                    }
                }
            }
        }
    }

    public static int[][] isValidNode() {
        for (int i= 0; i < intGrid.length; i++) {
            for (int j= 0; j < intGrid[i].length; j++) {
                if (intGrid[i][j] == 1) {
                    return new int[][]{{i, j}};
                }
            }
        }
        return null;
    }

    public static int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        intGrid = new int[rowLength][colLength];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    intGrid[i][j] = 1;
                } else if (grid[i][j] == '0') {
                    intGrid[i][j] = 0;
                }
            }
        }

        visited = new boolean[rowLength][colLength];
        int count = 0;

        while(true) {
            int[][] currentGrid = isValidNode();
            if (currentGrid == null) {
                break;
            } else {
                int row = currentGrid[0][0];
                int col = currentGrid[0][1];
                bfs(row, col);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
}
