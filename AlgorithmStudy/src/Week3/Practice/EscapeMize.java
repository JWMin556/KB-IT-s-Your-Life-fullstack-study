package Week3.Practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class EscapeMize {
    static int[][] distance;
    static char[][] grid;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int rowLength;
    static int colLength;

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < rowLength && col >= 0 && col < colLength && grid[row][col] != 'X';
    }

    public static int bfs(int beginRow, int beginCol, int endRow, int endCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        distance = new int[rowLength][colLength];
        for (int[] d : distance) {
            Arrays.fill(d, -1);
        }
        if (!isValid(beginRow, beginCol)) {
            return -1;
        }
        queue.add(new int[]{beginRow, beginCol});
        distance[beginRow][beginCol] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for (int k = 0; k < dr.length; k++) {
                int newRow = curRow + dr[k];
                int newCol = curCol + dc[k];
                if (isValid(newRow, newCol)) {
                    if (distance[newRow][newCol] == -1) {
                        queue.add(new int[]{newRow, newCol});
                        distance[newRow][newCol] = distance[curRow][curCol] + 1;
                    }
                }
            }
        }
        return distance[endRow][endCol];
    }

    public static int solution(String[] maps) {
        int answer = 0;
        rowLength = maps.length;
        colLength = maps[0].length();
        grid = new char[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                grid[i][j] = maps[i].charAt(j);
            }
        }
        int startRow = 0;
        int startCol = 0;
        int leverRow = 0;
        int leverCol = 0;
        int endRow = 0;
        int endCol = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
                else if (grid[i][j] == 'L') {
                    leverRow = i;
                    leverCol = j;
                } else if (grid[i][j] == 'E') {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        if (bfs(startRow, startCol, leverRow, leverCol) == -1 || bfs(leverRow, leverCol, endRow, endCol) == -1) {
            answer = -1;
        } else {
            int first = bfs(startRow, startCol, leverRow, leverCol);
            int last = bfs(leverRow, leverCol, endRow, endCol);
            answer = bfs(startRow, startCol, leverRow, leverCol) + bfs(leverRow, leverCol, endRow, endCol);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }
}
