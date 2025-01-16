import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Permutation2 {
    public static void permuteUniqueHelper(List<Integer> nums, List<List<Integer>> ans, int start) {
        // base case
        if (start == nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = start; i < nums.size(); i++) {
            if (visited.containsKey(nums.get(i))) {
                continue;
            }
            visited.put(nums.get(i), true);
            Collections.swap(nums, i, start);
            permuteUniqueHelper(nums, ans, start + 1);
            Collections.swap(nums, i, start);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        permuteUniqueHelper(numList, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2 };
        System.out.println(permuteUnique(nums1));
        int nums2[] = { 1, 2, 3 };
        System.out.println(permuteUnique(nums2));
    }
}
