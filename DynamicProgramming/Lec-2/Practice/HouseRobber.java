import java.util.Arrays;

public class HouseRobber {
    public static int solveUsingRec(int nums[], int index) {
        if (index >= nums.length) {
            return 0;
        }

        int include = nums[index] + solveUsingRec(nums, index + 2);
        int exclude = solveUsingRec(nums, index + 1);

        return Math.max(include, exclude);
    }

    public static int solveUsingMemo(int nums[], int index, int dp[]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int include = nums[index] + solveUsingMemo(nums, index + 2, dp);
        int exclude = solveUsingMemo(nums, index + 1, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    public static int solveUsingTabulation(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[n - 1] = nums[n - 1];

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if (index + 2 < n) {
                tempAns = dp[index + 2];
            }

            int include = nums[index] + tempAns;
            int exclude = dp[index + 1];
            dp[index] = Math.max(include, exclude);
        }

        return dp[0];
    }

    public static int solveUsingTabulationSO(int nums[]) {
        int n = nums.length;
        int prev = nums[n - 1];
        int next = 0;
        int curr;

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if (index + 2 < n) {
                tempAns = next;
            }

            int include = nums[index] + tempAns;
            int exclude = prev;
            curr = Math.max(include, exclude);
            next = prev;
            prev = curr;
        }

        return prev;
    }

    public static int rob(int[] nums) {
        // int index = 0;
        // return solveUsingRec(nums, index);
        // int dp[] = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(nums, index, dp);

        return solveUsingTabulationSO(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}