import java.util.Arrays;

public class HouseRobber2 {
    public static int solveUsingRec(int nums[], int index, int end) {
        // base case
        if (index > end) {
            return 0;
        }

        int include = nums[index] + solveUsingRec(nums, index + 2, end);
        int exclude = 0 + solveUsingRec(nums, index + 1, end);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMem(int nums[], int index, int end, int dp[]) {
        if (index > end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int include = nums[index] + solveUsingMem(nums, index + 2, end, dp);
        int exclude = 0 + solveUsingMem(nums, index + 1, end, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    public static int solveUsingTab(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < n; index++) {
            int include = nums[index] + dp[index - 2];
            int exclude = dp[index - 1];
            dp[index] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

    public static int solveUsingTabSpaceOptimization(int nums[], int start, int end) {
        int prev2 = 0;
        int prev1 = nums[end];

        for (int index = end - 1; index >= start; index--) {
            int include = nums[index] + prev2;
            int exclude = prev1;
            int curr = Math.max(include, exclude);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(solveUsingTabSpaceOptimization(nums, 0, n - 2), solveUsingTabSpaceOptimization(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 3, 2 };
        System.out.println(rob(nums1)); 
        int nums2[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums2)); 
        int nums3[] = { 1, 2, 3 };
        System.out.println(rob(nums3)); 
    }
}
