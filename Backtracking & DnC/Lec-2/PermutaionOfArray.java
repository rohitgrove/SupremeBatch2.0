import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutaionOfArray {
    public static List<List<Integer>> permute(int[] nums1) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int num : nums1) {
            nums.add(num);
        }
        int index = 0;
        solve(nums, ans, index);
        return ans;
    }

    public static void solve(List<Integer> nums, List<List<Integer>> ans, int index) {
        if (index >= nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            solve(nums, ans, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
