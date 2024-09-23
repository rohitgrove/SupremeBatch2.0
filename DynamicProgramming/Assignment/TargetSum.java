import java.util.Arrays;

public class TargetSum {
    static int total = 0;

    public static int solveUsingRec(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return target == sum ? 1 : 0;
        }

        int plus = solveUsingRec(nums, target, idx + 1, sum + nums[idx]);
        int minus = solveUsingRec(nums, target, idx + 1, sum - nums[idx]);
        return plus + minus;
    }

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
        // Step 1: Calculate total sum of all elements
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // Edge case: If the target is out of possible bounds, return 0
        if (Math.abs(target) > total) {
            return 0;
        }

        // Step 2: Define dp array with size (nums.length + 1) x (2 * total + 1)
        int[][] dp = new int[nums.length + 1][2 * total + 1];

        // Step 3: Initialize base case (dp[nums.length][total + target] = 1)
        dp[nums.length][total] = 1; // base case when the sum is zero

        // Step 4: Fill the DP table in reverse
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            for (int sum = -total; sum <= total; sum++) {
                int currentSum = sum + total;
                if (dp[idx + 1][currentSum] != 0) {
                    // Add case
                    dp[idx][currentSum + nums[idx]] += dp[idx + 1][currentSum];
                    // Subtract case
                    dp[idx][currentSum - nums[idx]] += dp[idx + 1][currentSum];
                }
            }
        }

        // Step 5: The result is stored in dp[0][total + target]
        return dp[0][total + target];
    }

    public static int findTargetSumWays(int[] nums, int target) {
        // for (int num : nums) {
        //     total += num;
        // }
        // int dp[][] = new int[nums.length + 1][2 * total + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // int sum = 0;
        return solveUsingTabulation(nums, target);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 1, 1, 1 }, target1 = 3;
        System.out.println(findTargetSumWays(nums1, target1));
        int nums2[] = { 1 }, target2 = 1;
        System.out.println(findTargetSumWays(nums2, target2));
    }
}
