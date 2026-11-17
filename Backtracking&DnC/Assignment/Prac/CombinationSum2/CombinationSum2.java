import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void combinationSumHelper(int[] candidates, int target, List<Integer> currAns, List<List<Integer>> ans, int idx) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currAns.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], currAns, ans, i + 1);
            currAns.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> currAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(candidates, target, currAns, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 2, 3, 6, 7 };
        System.out.println(combinationSum(candidates1, 7));
        int candidates2[] = { 2, 3, 5 };
        System.out.println(combinationSum(candidates2, 8));
    }
}
