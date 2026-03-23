import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void combinationSumHelper(int candidates[], int target, List<List<Integer>> ans, List<Integer> path, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], ans, path, i + 1);
            path.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSumHelper(candidates, target, ans, path, 0);

        return ans;
    }

    public static void main(String[] args) {
        int candidates1[] = { 10, 1, 2, 7, 6, 1, 5 }, target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));
        int candidates2[] = { 2, 5, 2, 1, 2 }, target2 = 5;
        System.out.println(combinationSum2(candidates2, target2));
    }
}
