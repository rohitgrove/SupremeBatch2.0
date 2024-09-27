import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int solveUsingRecursion(int[] nums, int curr, int prev) {
        // base case
        if (curr >= nums.length) {
            return 0;
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingRecursion(nums, curr + 1, curr);
        }
        int exclude = 0 + solveUsingRecursion(nums, curr + 1, prev);

        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int[] nums, int curr, int prev, int dp[][]) {
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int include = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + solveUsingMemo(nums, curr + 1, curr, dp);
        }

        int exlude = 0 + solveUsingMemo(nums, curr + 1, prev, dp);

        dp[curr][prev + 1] = Math.max(include, exlude);
        return dp[curr][prev + 1];
    }

    public static int solveUsingTabulation(int nums[]) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];

        for (int curr_index = nums.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || nums[curr_index] > nums[prev_index]) {
                    include = 1 + dp[curr_index + 1][curr_index + 1];
                }

                int exlude = 0 + dp[curr_index + 1][prev_index + 1];

                dp[curr_index][prev_index + 1] = Math.max(include, exlude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int nums[]) {
        int nextRow[] = new int[nums.length + 1];
        int currRow[] = new int[nums.length + 1];

        for (int curr_index = nums.length - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {
                int include = 0;
                if (prev_index == -1 || nums[curr_index] > nums[prev_index]) {
                    include = 1 + nextRow[curr_index + 1];
                }

                int exlude = 0 + nextRow[prev_index + 1];

                currRow[prev_index + 1] = Math.max(include, exlude);
            }
            // shifting
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingBS(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        // initial state
        ans.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.getLast()) {
                ans.add(nums[i]);
            } else {
                // just bada number exist karta hai
                int index = Collections.binarySearch(ans, nums[i]);
                if (index < 0) {
                    index = Math.abs(index) - 1;
                }

                // replace
                ans.set(index, nums[i]);
            }
        }

        return ans.size();
    }

    public static int lengthOfLIS(int[] nums) {
        // int curr = 0;
        // int prev = -1;
        // int dp[][] = new int[nums.length + 1][nums.length + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        int ans = solveUsingBS(nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums1));
        int nums2[] = { 0, 1, 0, 3, 2, 3 };
        System.out.println(lengthOfLIS(nums2));
        int nums3[] = { 7, 7, 7, 7, 7, 7, 7 };
        System.out.println(lengthOfLIS(nums3));
        int nums4[] = { 2, 8, 9, 5, 6, 7, 0, 10 };
        System.out.println(lengthOfLIS(nums4));
    }
}