import java.util.Arrays;
import java.util.HashMap;

public class MinimumCostTreeFromLeafValues {
    public static int solveUsingRecursion(int[] arr, HashMap<String, Integer> maxi, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.min(ans, (maxi.get(start + "," + i) * maxi.get((i + 1) + "," + end)) +
                    solveUsingRecursion(arr, maxi, start, i) +
                    solveUsingRecursion(arr, maxi, i + 1, end));
        }
        return ans;
    }

    public static int solveUsingMemo(int[] arr, HashMap<String, Integer> maxi, int start, int end, int dp[][]) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.min(ans, (maxi.get(start + "," + i) * maxi.get((i + 1) + "," + end)) +
                    solveUsingMemo(arr, maxi, start, i, dp) +
                    solveUsingMemo(arr, maxi, i + 1, end, dp));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }

    public static int solveUsingTabulation(int arr[], HashMap<String, Integer> maxi) {
        int n = arr.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int start_index = n; start_index >= 0; start_index--) {
            for (int end_index = 0; end_index <= n - 1; end_index++) {
                if (start_index >= end_index) {
                    // invalid range
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                for (int i = start_index; i < end_index; i++) {
                    ans = Math.min(ans, (maxi.get(start_index + "," + i) * maxi.get((i + 1) + "," + end_index)) +
                            dp[start_index][i] + dp[i + 1][end_index]);
                }
                dp[start_index][end_index] = ans;
            }
        }

        return dp[0][n - 1];
    }

    public static int mctFromLeafValues(int[] arr) {
        HashMap<String, Integer> maxi = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            maxi.put(i + "," + i, arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                maxi.put(i + "," + j, Math.max(arr[j], maxi.get(i + "," + (j - 1))));
            }
        }
        // int n = arr.length;
        // int start = 0;
        // int end = n - 1;
        // int ans = solveUsingRecursion(arr, maxi, start, end);
        // int dp[][] = new int[n + 1][n + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        int ans = solveUsingTabulation(arr, maxi);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 4 };
        System.out.println(mctFromLeafValues(arr));
    }
}