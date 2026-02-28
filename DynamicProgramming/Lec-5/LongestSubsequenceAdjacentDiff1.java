import java.util.Arrays;
import java.util.HashMap;

public class LongestSubsequenceAdjacentDiff1 {
    public static int solveUsingRec(int[] nums, int curr, int prev) {
        // base case
        if (curr >= nums.length) {
            return 0;
        }

        int include = 0;
        if (prev == -1 || Math.abs(nums[curr] - nums[prev]) == 1) {
            include = 1 + solveUsingRec(nums, curr + 1, curr);
        }

        int exclude = 0 + solveUsingRec(nums, curr + 1, prev);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int[] nums, int curr, int prev, int dp[][]) {
        // base case
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int include = 0;
        if (prev == -1 || Math.abs(nums[curr] - nums[prev]) == 1) {
            include = 1 + solveUsingMemo(nums, curr + 1, curr, dp);
        }

        int exclude = 0 + solveUsingMemo(nums, curr + 1, prev, dp);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }

    public static int solveUsingTabulation(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || Math.abs(nums[curr] - nums[prev]) == 1) {
                    include = 1 + dp[curr + 1][curr + 1];
                }

                int exclude = 0 + dp[curr + 1][prev + 1];
                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int nums[]) {
        int n = nums.length;
        int currRow[] = new int[n + 1];
        int nextRow[] = new int[n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || Math.abs(nums[curr] - nums[prev]) == 1) {
                    include = 1 + nextRow[curr + 1];
                }

                int exclude = 0 + nextRow[prev + 1];
                currRow[prev + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingHM(int[] arr) {
        if (arr.length == 0) return 0;
        
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLength = 1;
        
        for (int num : arr) {
            int len1 = dp.getOrDefault(num - 1, 0);
            int len2 = dp.getOrDefault(num + 1, 0);
            
            int currLength = Math.max(len1, len2) + 1;
            dp.put(num, currLength);
            
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
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

        int ans = solveUsingTabulation(nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 9, 4, 5, 4, 8, 6 };
        System.out.println(lengthOfLIS(nums1));
        int nums2[] = { 1, 2, 3, 4, 5 };
        System.out.println(lengthOfLIS(nums2));
    }
}