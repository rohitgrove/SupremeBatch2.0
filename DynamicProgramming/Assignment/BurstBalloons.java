import java.util.Arrays;

public class BurstBalloons {
    public static int solveUsingRecursion(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        int coins = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            coins = Math.max(coins, nums[start - 1] * nums[i] * nums[end + 1]
                    + solveUsingRecursion(nums, start, i - 1)
                    + solveUsingRecursion(nums, i + 1, end));
        }

        return coins;
    }

    public static int solveUsingMemo(int[] nums, int start, int end, int dp[][]) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int coins = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            coins = Math.max(coins, nums[start - 1] * nums[i] * nums[end + 1]
                    + solveUsingMemo(nums, start, i - 1, dp)
                    + solveUsingMemo(nums, i + 1, end, dp));
        }

        dp[start][end] = coins;
        return dp[start][end];
    }

    public static int solveUsingTabulation(int[] nums) {
        int n = nums.length - 2;
        int[][] dp = new int[nums.length][nums.length];

        for (int start = n; start >= 1; --start) {
            for (int end = start; end <= n; ++end) {
                int coins = Integer.MIN_VALUE;
                for (int i = start; i <= end; ++i) {
                    coins = Math.max(coins, nums[start - 1] * nums[i] * nums[end + 1]
                            + dp[start][i - 1]
                            + dp[i + 1][end]);
                }
                dp[start][end] = coins;
            }
        }
        return dp[1][n];
    }

    public static int maxCoins(int[] nums) {
        int newNums[] = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[nums.length + 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        // int dp[][] = new int[nums.length + 1][nums.length + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(newNums, 1, newNums.length - 2, dp);

        return solveUsingTabulation(newNums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums1));
        int nums2[] = { 1, 5 };
        System.out.println(maxCoins(nums2));
    }
}
