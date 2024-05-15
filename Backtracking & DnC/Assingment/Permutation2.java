import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Permutation2 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> List = new ArrayList<>();
        for (int num : nums) {
            List.add(num);
        }
        int index = 0;
        solve(List, ans, index);
        return ans;
    }

    public static void solve(List<Integer> nums, List<List<Integer>> ans, int index) {
        if (index >= nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = index; i < nums.size(); i++) {
            if (visited.containsKey(nums.get(i))) {
                continue;
            }
            visited.put(nums.get(i), true);
            Collections.swap(nums, index, i);
            solve(nums, ans, index + 1);
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        System.out.println(permute(nums1));
        int nums2[] = { 1, 1, 2 };
        System.out.println(permute(nums2));
    }
}
