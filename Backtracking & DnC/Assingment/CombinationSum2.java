import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum_helper(candidates, target, path, ans, 0);
        return ans;
    }

    public static void combinationSum_helper(int[] candidates, int target, List<Integer> path, List<List<Integer>> ans,
            int index) {
        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            combinationSum_helper(candidates, target - candidates[i], path, ans, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 2, 1, 2 };
        int target = 5;
        System.out.println(combinationSum(nums, target));
    }
}
