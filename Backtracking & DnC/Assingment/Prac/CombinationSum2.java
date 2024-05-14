import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum(int nums[], int target) {
        Arrays.sort(nums);
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
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            combinationSum_helper(nums, target - nums[i], i + 1, path, result);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int candidates1[] = { 10, 1, 2, 7, 6, 1, 5 }, target1 = 8;
        System.out.println(combinationSum(candidates1, target1));
        int candidates2[] = { 2, 5, 2, 1, 2 }, target2 = 5;
        System.out.println(combinationSum(candidates2, target2));
    }
}
