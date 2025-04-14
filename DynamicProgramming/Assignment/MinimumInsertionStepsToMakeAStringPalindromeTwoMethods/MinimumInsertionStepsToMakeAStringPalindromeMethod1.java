import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindromeMethod1 {
    public static int solveUsingRecursion(String s, int start, int end) {
        if (start > end) {
            return 0;
        }

        int ans;
        if (s.charAt(start) != s.charAt(end)) {
            int case1 = solveUsingRecursion(s, start + 1, end);
            int case2 = solveUsingRecursion(s, start, end - 1);
            ans = Math.min(case1, case2) + 1;
        } else {
            ans = solveUsingRecursion(s, start + 1, end - 1);
        }

        return ans;
    }

    public static int solveUsingMemo(String s, int start, int end, int dp[][]) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans;
        if (s.charAt(start) != s.charAt(end)) {
            int case1 = solveUsingMemo(s, start + 1, end, dp);
            int case2 = solveUsingMemo(s, start, end - 1, dp);
            ans = Math.min(case1, case2) + 1;
        } else {
            ans = solveUsingMemo(s, start + 1, end - 1, dp);
        }

        dp[start][end] = ans;
        return dp[start][end];
    }

    public static int solveUsingTabulation(String str) {
        int dp[][] = new int[str.length() + 1][str.length() + 1];

        for (int start = str.length() - 1; start >= 0; start--) {
            for (int end = 1; end < str.length(); end++) {
                if (start > end) {
                    continue;
                }
                int ans;
                if (str.charAt(start) != str.charAt(end)) {
                    int case1 = dp[start + 1][end];
                    int case2 = dp[start][end - 1];
                    ans = Math.min(case1, case2) + 1;
                } else {
                    ans = dp[start + 1][end - 1];
                }

                dp[start][end] = ans;
            }
        }

        return dp[0][str.length() - 1];
    }

    public static int solveUsingTabulationSO(String str) {
        int n = str.length();
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int start = n - 1; start >= 0; start--) {
            curr[start] = 0;

            for (int end = start + 1; end < n; end++) {
                if (str.charAt(start) == str.charAt(end)) {
                    curr[end] = prev[end - 1];
                } else {
                    curr[end] = Math.min(prev[end], curr[end - 1]) + 1;
                }
            }

            prev = curr.clone();
        }

        return prev[n - 1];
    }

    public static int minInsertions(String s) {
        // return solveUsingRecursion(s, 0, s.length() - 1);
        // int dp[][] = new int[s.length() + 1][s.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(s, 0, s.length() - 1, dp);

        // return solveUsingTabulation(s);
        return solveUsingTabulationSO(s);
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }
}
