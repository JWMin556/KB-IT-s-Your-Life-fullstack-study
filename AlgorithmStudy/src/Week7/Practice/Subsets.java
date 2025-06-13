package Week7.Practice;

import java.util.*;

public class Subsets { // k는 현재 몇개 까지 할 것인지 판단
    public static void backstrack(int start, int k, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            backstrack(i + 1, k, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backstrack(0, k, nums, new ArrayList<>(), result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
