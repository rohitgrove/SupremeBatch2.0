import java.util.Arrays;

public class PredictWinner {
    public static int solveUsingRec(int nums[], int start, int end) {
        if (start == end) {
            return nums[start];
        }

        // diff = p1 - p2;
        int diffByStart = nums[start] - solveUsingRec(nums, start + 1, end);
        int diffByEnd = nums[end] - solveUsingRec(nums, start, end - 1);
        return Math.max(diffByStart, diffByEnd);
    }

    public static int solveUsingMemo(int nums[], int start, int end, int dp[][]) {
        if (start == end) {
            return nums[start];
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int diffByStart = nums[start] - solveUsingMemo(nums, start + 1, end, dp);
        int diffByEnd = nums[end] - solveUsingMemo(nums, start, end - 1, dp);
        return dp[start][end] = Math.max(diffByStart, diffByEnd);
    }

    public static int solveUsingTabulation(int nums[]) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = nums[i];
        }

        int i = nums.length;
        for (int start = nums.length - 1; start >= 0; start--) {
            for (int end = i; end < nums.length; end++) {
                int diffByStart = nums[start] - dp[start + 1][end];
                int diffByEnd = nums[end] - dp[start][end - 1];
                dp[start][end] = Math.max(diffByStart, diffByEnd);
            }
            i--;
        }

        return dp[0][nums.length - 1];
    }

    public static boolean predictTheWinner(int[] nums) {
        // return solveUsingRec(nums, 0, nums.length - 1) >= 0;

        // int dp[][] = new int[nums.length][nums.length];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(nums, 0, nums.length - 1, dp) >= 0;

        return solveUsingTabulation(nums) >= 0;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 5, 2 };
        System.out.println(predictTheWinner(nums1));
        int nums2[] = { 1, 5, 233, 7 };
        System.out.println(predictTheWinner(nums2));
    }
}
