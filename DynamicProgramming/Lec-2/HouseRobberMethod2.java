public class HouseRobberMethod2 {
    public static int solveUsingRec(int nums[], int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        int include = nums[idx] + solveUsingRec(nums, idx + 2);
        int exclude = 0 + solveUsingRec(nums, idx + 1);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int nums[], int idx, int dp[]) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int include = nums[idx] + solveUsingMemo(nums, idx + 2, dp);
        int exclude = 0 + solveUsingMemo(nums, idx + 1, dp);
        dp[idx] = Math.max(include, exclude);
        return dp[idx];
    }

    public static int solveUsingTablation(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        dp[n - 1] = nums[n - 1];

        for (int idx = n - 2; idx >= 0; idx--) {
            int include = nums[idx] + dp[idx + 2];
            int exclude = 0 + dp[idx + 1];
            dp[idx] = Math.max(include, exclude);
        }

        return dp[0];
    }

    public static int solveUsingTabulationSO(int nums[]) {
        int n = nums.length;
        int prev = nums[n - 1];
        int next = 0;
        int curr;

        for (int idx = n - 2; idx >= 0; idx--) {
            int include = nums[idx] + next;
            int exclude = 0 + prev;
            curr = Math.max(include, exclude);

            // bhul jata hu
            next = prev;
            prev = curr;
        }

        return prev;
    }

    public static int rob(int[] nums) {
        // return solveUsingRec(nums, 0);
        // int dp[] = new int[nums.length + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(nums, 0, dp);

        return solveUsingTabulationSO(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
        int nums2[] = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums2));
    }
}
