package Week7.Example;

import java.util.Arrays;

public class TwoSum {
    private int[] find(int[] nums, int target, int i, int j) {
        if (j >= nums.length) {
            return null;
        }

        if (nums[i] + nums[j] == target) {
            return new int[]{i, j};
        }

        return find(nums, target, i, j + 1);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int[] result = find(nums, target, i, i + 1);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4}, 6)));
//        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2,3,4}, 6)));
    }
}
