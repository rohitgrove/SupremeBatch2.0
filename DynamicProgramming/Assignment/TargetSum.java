import java.util.Arrays;

public class TargetSum {
    public static int solveUsingRec(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return target == sum ? 1 : 0;
        }

        int plus = solveUsingRec(nums, target, idx + 1, sum + nums[idx]);
        int minus = solveUsingRec(nums, target, idx + 1, sum - nums[idx]);
        return plus + minus;
    }

    static int total = 0;

    public static int solveUsingMemo(int nums[], int target, int idx, int sum, int dp[][]) {
        if (idx == nums.length) {
            return target == sum ? 1 : 0;
        }

        if (dp[idx][total + sum] != -1) {
            return dp[idx][total + sum];
        }

        int plus = solveUsingMemo(nums, target, idx + 1, sum + nums[idx], dp);
        int minus = solveUsingMemo(nums, target, idx + 1, sum - nums[idx], dp);
        dp[idx][total + sum] = plus + minus;
        return plus + minus;
    }

    public static int solveUsingTabulation(int[] nums, int target) {
        total = 0;
        for (int num : nums) {
            total += num;
        }
        if (Math.abs(target) > total) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][2 * total + 1];
        dp[nums.length][total] = 1;
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int sum = -total; sum <= total; sum++) {
                int currentSum = sum + total;
                if (dp[idx + 1][currentSum] != 0) {

                    dp[idx][currentSum + nums[idx]] += dp[idx + 1][currentSum];

                    dp[idx][currentSum - nums[idx]] += dp[idx + 1][currentSum];
                }
            }
        }

        return dp[0][total + target];
    }

    public static int findTargetSumWays(int[] nums, int target) {
        // int sum = 0;
        // return solveUsingRec(nums, target, 0, sum);
        // for (int num : nums) {
        // total += num;
        // }

        // int dp[][] = new int[nums.length + 1][2 * total + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(nums, target, 0, sum, dp);
        return solveUsingTabulation(nums, target);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1 }, target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
