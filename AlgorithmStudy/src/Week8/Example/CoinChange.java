package Week8.Example;

import java.util.Arrays;

public class CoinChange {
//    static int minCount = Integer.MAX_VALUE;
//    static int initMinCount = minCount;
//
//    public static void dfs(int[] coins, int remainsAmount, int count) {
//        if (remainsAmount < 0) return;
//        if (remainsAmount == 0) {
//            minCount = Math.min(minCount, count);
//            return;
//        }
//
//        for (int i = 0; i < coins.length; i++) {
//            dfs(coins, remainsAmount - coins[i], count + 1);
//        }
//    }
//
//    public static int coinChange(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        dfs(coins, amount, 0);
//        if (minCount == initMinCount) return -1;
//        return minCount;
//    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        int[] coins1 = {1, 2, 5};
//        System.out.println(coinChange(coins1, 11));

        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3));

//        int[] coins3 = {1};
//        System.out.println(coinChange(coins3, 0));
    }
}
