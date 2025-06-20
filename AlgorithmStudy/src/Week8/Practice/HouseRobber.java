package Week8.Practice;

public class HouseRobber {
//    실패한 방법 - 너무 오래걸림
//    static int maxCount = Integer.MIN_VALUE;
//    static boolean[] visited;
//
//    public static void recursive(int[] nums, int cumulativeMoney, int lastIndex) {
//        maxCount = Math.max(maxCount, cumulativeMoney);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!visited[i] && i > lastIndex + 1) {
//                visited[i] = true;
//                recursive(nums, cumulativeMoney + nums[i], i);
//                visited[i] = false;
//            }
//        }
//    }
//
//    public static int robArbitary(int[] nums) {
//        maxCount = Integer.MIN_VALUE;
//        visited = new boolean[nums.length];
//        recursive(nums, 0, -2);
//        return maxCount;
//    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {return 0;}
        if (nums.length == 1) {return nums[0];}

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
        System.out.println(rob(nums));
    }
}
