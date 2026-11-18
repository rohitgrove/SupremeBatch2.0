import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Permutation2 {
    public static void solve(List<Integer> numsList, int start, List<List<Integer>> ans) {
        if (start == numsList.size()) {
            ans.add(new ArrayList<>(numsList));
            return;
        }

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = start; i < numsList.size(); i++) {
            if (visited.containsKey(numsList.get(i))) {
                continue;
            }
            visited.put(numsList.get(i), true);
            Collections.swap(numsList, i, start);
            solve(numsList, start + 1, ans);
            Collections.swap(numsList, i, start);
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
        int nums1[] = { 1, 2, 3 };
        System.out.println(permute(nums1));
        int nums2[] = { 0, 1 };
        System.out.println(permute(nums2));
    }
}
