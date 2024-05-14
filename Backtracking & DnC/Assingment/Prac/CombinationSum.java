import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int nums[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combinationSum_helper(nums, target, 0, ans, result);
        return result;
    }

    public static void combinationSum_helper(int nums[], int target, int index, List<Integer> path,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            combinationSum_helper(nums, target - nums[i], i, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }
}
