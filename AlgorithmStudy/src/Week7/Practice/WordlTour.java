package Week7.Practice;

public class WordlTour {
    static int maxCount = 0;
    static boolean[] visited;

    public static void dfs(int balance, int count, int[][] countries) {
        maxCount = Math.max(maxCount, count);
        for (int i = 0; i < countries.length; i++) {
            int cost = countries[i][0];
            int required = countries[i][1];
            if (!visited[i] && balance >= required) {
                visited[i] = true;
                dfs(balance - cost, count + 1, countries);
                visited[i] = false;
            }
        }
    }

    public static int solution(int balance, int[][] countries) {
        maxCount = 0;
        visited = new boolean[countries.length];
        dfs(balance, 0, countries);
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] countries = {{70, 350}, {100, 550}, {350, 400}};
        int balance = 600;
        System.out.println(solution(balance, countries));
    }
}
