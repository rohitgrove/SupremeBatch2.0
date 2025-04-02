import java.util.Arrays;

public class HouseRobber2 {
    public static int solveUsingRec(int nums[], int start, int end) {
        // base case
        if (start > end) {
            return 0;
        }

        // recursive relation
        int include = nums[start] + solveUsingRec(nums, start + 2, end);
        int exclude = solveUsingRec(nums, start + 1, end);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int nums[], int start, int end, int dp[]) {
        // base case
        if (start > end) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        // recursive relation
        int include = nums[start] + solveUsingMemo(nums, start + 2, end, dp);
        int exclude = solveUsingMemo(nums, start + 1, end, dp);
        dp[start] = Math.max(include, exclude);
        return dp[start];
    }

    public static int solveUsingTabulation(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[n - 1]; // First house included, last excluded
        int[] dp2 = new int[n - 1]; // First house excluded, last included

        // Calculate for first house included, last excluded
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        // Calculate for first house excluded, last included
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 2]);
    }

    public static int solveUsingTabulationSO(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Calculate for first house included, last excluded
        int prev2_1 = nums[0];
        int prev1_1 = Math.max(nums[0], nums[1]);
        int current_1 = 0;
        for (int i = 2; i < n - 1; i++) {
            current_1 = Math.max(prev1_1, prev2_1 + nums[i]);
            prev2_1 = prev1_1;
            prev1_1 = current_1;
        }

        // Calculate for first house excluded, last included
        int prev2_2 = nums[1];
        int prev1_2 = Math.max(nums[1], nums[2]);
        int current_2 = 0;
        for (int i = 2; i < n - 1; i++) {
            current_2 = Math.max(prev1_2, prev2_2 + nums[i + 1]);
            prev2_2 = prev1_2;
            prev1_2 = current_2;
        }

        return Math.max(prev1_1, prev1_2);
    }

    public static int rob(int[] nums) {
        // int n = nums.length;
        // if (n == 1) {
        //     return nums[0];
        // }

        // if (n == 2) {
        //     return Math.max(nums[0], nums[1]);
        // }

        // int[] dp1 = new int[n];
        // int[] dp2 = new int[n];
        // Arrays.fill(dp1, -1);
        // Arrays.fill(dp2, -1);

        // int option1 = solveUsingMemo(nums, 0, nums.length - 2, dp1);
        // int option2 = solveUsingMemo(nums, 1, nums.length - 1, dp2);
        // return Math.max(option1, option2);

        return solveUsingTabulationSO(nums);
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
