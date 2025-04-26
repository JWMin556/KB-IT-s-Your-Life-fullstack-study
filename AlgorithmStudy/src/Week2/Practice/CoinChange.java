package Week2.Practice;

import java.util.*;

public class CoinChange {
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void makeGrapth(int[] coins, int amount) {
        for (int i = amount; i >= 0; i--) {
            List<Integer> neighbors = new ArrayList<>();
            for (int coin : coins) {
                int next = i - coin;
                if (next >= 0) {
                    neighbors.add(next);
                }
            }
            graph.put(i, neighbors);
        }
    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                return distance.get(current);
            }

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) { return 0; }
        makeGrapth(coins, amount);
        return bfs(amount, 0);
    }

    public static void main(String[] args) {
        int coins[] = {1,2,5};
        System.out.println(coinChange(coins,11));
    }
}
