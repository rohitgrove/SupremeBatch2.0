import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfArray {
    public static void solve(List<Integer> nums, int idx, List<List<Integer>> ans) {
        if (idx >= nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int i = idx; i < nums.size(); i++) {
            Collections.swap(nums, i, idx);
            solve(nums, idx + 1, ans);
            Collections.swap(nums, i, idx);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        List<List<Integer>> ans = new ArrayList<>();
        solve(numsList, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
