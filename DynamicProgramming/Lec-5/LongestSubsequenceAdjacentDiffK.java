import java.util.HashMap;

public class LongestSubsequenceAdjacentDiffK {
    public static int solveUsingRec(int[] nums, int curr, int prev, int difference) {
        // base case
        if (curr >= nums.length) {
            return 0;
        }

        int include = 0;
        if (prev == -1 || nums[curr] - nums[prev] == difference) {
            include = 1 + solveUsingRec(nums, curr + 1, curr, difference);
        }

        int exclude = 0 + solveUsingRec(nums, curr + 1, prev, difference);
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static int solveUsingMemo(int[] nums, int curr, int prev, int dp[][], int difference) {
        // base case
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int include = 0;
        if (prev == -1 || nums[curr] - nums[prev] == difference) {
            include = 1 + solveUsingMemo(nums, curr + 1, curr, dp, difference);
        }

        int exclude = 0 + solveUsingMemo(nums, curr + 1, prev, dp, difference);
        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }

    public static int solveUsingTabulation(int nums[], int difference) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] - nums[prev] == difference) {
                    include = 1 + dp[curr + 1][curr + 1];
                }

                int exclude = 0 + dp[curr + 1][prev + 1];
                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(int nums[], int difference) {
        int n = nums.length;
        int currRow[] = new int[n + 1];
        int nextRow[] = new int[n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[curr] - nums[prev] == difference) {
                    include = 1 + nextRow[curr + 1];
                }

                int exclude = 0 + nextRow[prev + 1];
                currRow[prev + 1] = Math.max(include, exclude);
            }
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int solveUsingHM(int[] arr, int difference) {
        int ans = 1;
        HashMap<Integer, Integer> dp = new HashMap<>();
        
        for (int val : arr) {
            if (!dp.containsKey(val - difference)) {
                dp.put(val, 1);
            } else {
                dp.put(val, dp.get(val - difference) + 1);
            }
            ans = Math.max(ans, dp.get(val));
        }
        
        return ans;
    }

    public static int lengthOfLIS(int[] nums, int difference) {
        // int curr = 0;
        // int prev = -1;
        // int ans = solveUsingRec(nums, curr, prev, difference);
        // int n = nums.length;
        // int dp[][] = new int[n + 1][n + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(nums, curr, prev, dp, difference);
        // return ans;

        int ans = solveUsingTabulation(nums, difference);
        return ans;
    }
}
