import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void combinationSumHelper(int[] candidates, int target, int sum, List<Integer> currAns,
            List<List<Integer>> ans, int idx) {
        if (target < sum) {
            return;
        }

        if (sum == target) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            currAns.add(candidates[i]);
            combinationSumHelper(candidates, target, sum + candidates[i], currAns, ans, i);
            currAns.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, currAns, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 2, 3, 6, 7 };
        System.out.println(combinationSum(candidates1, 7));
        int candidates2[] = { 2, 3, 5 };
        System.out.println(combinationSum(candidates2, 8));
    }
}
