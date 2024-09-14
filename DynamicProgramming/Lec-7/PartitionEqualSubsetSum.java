import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean solveUsingRecursion(int[] nums, int index, int sum, int target) {
        if (index >= nums.length) {
            return false;
        }

        if (sum > target) {
            return false;
        }

        if (sum == target) {
            return true;
        }

        boolean include = solveUsingRecursion(nums, index + 1, sum + nums[index], target);
        boolean exclude = solveUsingRecursion(nums, index + 1, sum, target);

        return include || exclude;
    }

    public static boolean solveUsingMemo(int nums[], int index, int sum, int target, Boolean dp[][]) {
        if (index >= nums.length) {
            return false;
        }

        if (sum > target) {
            return false;
        }

        if (sum == target) {
            return true;
        }

        if (dp[index][sum] != null) {
            return dp[index][sum];
        }

        boolean include = solveUsingMemo(nums, index + 1, sum + nums[index], target, dp);
        boolean exclude = solveUsingMemo(nums, index + 1, sum, target, dp);

        dp[index][sum] = (include || exclude);

        return dp[index][sum];
    }

    public static boolean solveUsingTabulation(int nums[], int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 2][target + 1];

        for (int row = 0; row <= n; row++) {
            dp[row][target] = true;
        }

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int s = target; s >= 0; s--) {
                boolean include = false;
                if (s + nums[ind] <= target) {
                    include = dp[ind + 1][s + nums[ind]];
                }

                boolean exclude = dp[ind + 1][s];
                dp[ind][s] = include || exclude;
            }
        }

        return dp[0][0];
    }

    public static boolean solveUsingTabulationSO(int nums[], int target) {
        int n = nums.length;
        boolean curr[] = new boolean[target + 1];
        boolean next[] = new boolean[target + 1];

        curr[target] = true;
        next[target] = true;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int s = target; s >= 0; s--) {
                boolean include = false;
                if (s + nums[ind] <= target) {
                    include = next[s + nums[ind]];
                }

                boolean exclude = next[s];
                curr[s] = include || exclude;
            }
            // shifting
            next = curr.clone();
        }

        return next[0];
    }

    public static boolean canPartition(int[] nums) {
        int index = 0;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            // odd cannot be partioned
            return false;
        }

        int target = totalSum / 2;
        int currSum = 0;

        Boolean dp[][] = new Boolean[nums.length + 1][target];
        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }

        boolean ans = solveUsingTabulationSO(nums, target);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums1));
        int nums2[] = { 1, 2, 3, 5 };
        System.out.println(canPartition(nums2));
    }
}