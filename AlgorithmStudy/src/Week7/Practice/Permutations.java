package Week7.Practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void make(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);
            make(nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        make(nums, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
