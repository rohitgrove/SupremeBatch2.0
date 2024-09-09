import java.util.Arrays;

public class HouseRobber {
    public static int solveUsingRec(int nums[], int index) {
        // base case
        if (index >= nums.length) {
            return 0;
        }

        // recursive relation
        int include = nums[index] + solveUsingRec(nums, index + 2);
        int exclude = 0 + solveUsingRec(nums, index + 1);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMem(int nums[], int index, int dp[]) {
        // base case
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // recursive relation
        int include = nums[index] + solveUsingMem(nums, index + 2, dp);
        int exclude = 0 + solveUsingMem(nums, index + 1, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    public static int solveUsingTab(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        // step 1
        Arrays.fill(dp, -1);

        // step 2
        dp[n - 1] = nums[n - 1];

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if ((index + 2) < n) {
                tempAns = dp[index + 2];
            }
            int include = nums[index] + tempAns;
            int exclude = 0 + dp[index + 1];
            dp[index] = Math.max(include, exclude);
        }

        return dp[0];
    }

    public static int solveUsingTabOneMoreMethod(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];

        // step 2
        dp[n - 1] = nums[n - 1];

        for (int index = n - 2; index >= 0; index--) {
            int include = nums[index] + dp[index + 2];
            int exclude = 0 + dp[index + 1];
            dp[index] = Math.max(include, exclude);
        }

        return dp[0];
    }

    public static int solveUsingTabSpaceOptimization(int nums[]) {
        int n = nums.length;

        // step 2
        int prev = nums[n - 1];
        int next = 0;
        int curr;

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if ((index + 2) < n) {
                tempAns = next;
            }
            int include = nums[index] + tempAns;
            int exclude = 0 + prev;
            curr = Math.max(include, exclude);

            // bhul jata hu
            next = prev;
            prev = curr;
        }

        return prev;
    }

    public static int rob(int[] nums) {
        // return solveUingRec(nums, 0);

        // int dp[] = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return solveUsingMem(nums, 0, dp);

        return solveUsingTabSpaceOptimization(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
        int nums3[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums3));
    }
}