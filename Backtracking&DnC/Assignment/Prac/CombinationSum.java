import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], ans, path, i);
            path.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int candidates[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSumHelper(candidates, target, ans, path, 0);
        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 2, 3, 6, 7 }, target1 = 7;
        System.out.println(combinationSum(candidates1, target1));
        int candidates2[] = { 2, 3, 5 }, target2 = 8;
        System.out.println(combinationSum(candidates2, target2));
    }
}