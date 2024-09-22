import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static int solveUsingRec(String str, int start, int end) {
        if (start > end) {
            return 0;
        }

        int ans = 0;
        if (str.charAt(start) != str.charAt(end)) {
            int case1 = solveUsingRec(str, start + 1, end);
            int case2 = solveUsingRec(str, start, end - 1);
            ans = Math.min(case1, case2) + 1;
        } else {
            ans = solveUsingRec(str, start + 1, end - 1);
        }

        return ans;
    }

    public static int solveUsingMemo(String str, int start, int end, int dp[][]) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = 0;
        if (str.charAt(start) != str.charAt(end)) {
            int case1 = solveUsingMemo(str, start + 1, end, dp);
            int case2 = solveUsingMemo(str, start, end - 1, dp);
            ans = Math.min(case1, case2) + 1;
        } else {
            ans = solveUsingMemo(str, start + 1, end - 1, dp);
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
                int ans = 0;
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
        int curr[] = new int[str.length() + 1];
        int next[] = new int[str.length() + 1];

        for (int start = str.length() - 1; start >= 0; start--) {
            for (int end = 1; end < str.length(); end++) {
                if (start > end) {
                    continue;
                }
                int ans = 0;
                if (str.charAt(start) != str.charAt(end)) {
                    int case1 = next[end];
                    int case2 = curr[end - 1];
                    ans = Math.min(case1, case2) + 1;
                } else {
                    ans = next[end - 1];
                }

                curr[end] = ans;
            }
            next = curr.clone();
        }

        return next[str.length() - 1];
    }

    public static int minInsertions(String s) {
        return solveUsingTabulationSO(s);
    }

    public static void main(String[] args) {
        String s1 = "zzazz";
        System.out.println(minInsertions(s1));
        String s2 = "mbadm";
        System.out.println(minInsertions(s2));
        String s3 = "leetcode";
        System.out.println(minInsertions(s3));
    }
}
