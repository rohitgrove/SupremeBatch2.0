import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int solveUsingRec(int[] nums, int curr, int prev) {
        if (curr >= nums.length) {
            return 0;
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingRec(nums, curr + 1, curr);
        }
        int exclude = 0 + solveUsingRec(nums, curr + 1, prev);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int[] nums, int curr, int prev, int dp[][]) {
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev];
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingMemo(nums, curr + 1, curr, dp);
        }
        int exclude = 0 + solveUsingMemo(nums, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }

    public static int solveUsingTabulation(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] > nums[prev]) {
                    include = 1 + dp[curr + 1][curr + 1];
                }
                int exclude = 0 + dp[curr + 1][prev + 1];
                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int[] nums) {
        int n = nums.length;
        int currRow[] = new int[n + 1];
        int nextRow[] = new int[n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] > nums[prev]) {
                    include = 1 + nextRow[curr + 1];
                }
                int exclude = 0 + nextRow[prev + 1];
                currRow[prev + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingBS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.addLast(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.getLast()) {
                ans.addLast(nums[i]);
            } else {
                int index = Collections.binarySearch(ans, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }

                ans.set(index, nums[i]);
            }
        }

        return ans.size();
    }

    public static int lengthOfLIS(int[] nums) {
        // int curr = 0;
        // int prev = -1;
        // int ans = solveUsingRec(nums, curr, prev);
        // int n = nums.length;
        // int dp[][] = new int[n + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(nums, curr, prev, dp);
        // return ans;

        int ans = solveUsingBS(nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums1));
        int nums2[] = { 0, 1, 0, 3, 2, 3 };
        System.out.println(lengthOfLIS(nums2));
    }
}