import java.util.Arrays;

public class WildcardPatternMatching {
    public static boolean solve(String str, String pattern, int idx1, int idx2) {
        if (idx1 < 0 && idx2 < 0) {
            return true;
        }

        if (idx1 >= 0 && idx2 < 0) {
            return false;
        }

        if (idx1 < 0 && idx2 >= 0) {
            for (int i = 0; i <= idx2; i++) {
                if (pattern.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        // match
        if (str.charAt(idx1) == pattern.charAt(idx2) || pattern.charAt(idx2) == '?') {
            return solve(str, pattern, idx1 - 1, idx2 - 1);
        } else if (pattern.charAt(idx2) == '*') {
            return solve(str, pattern, idx1 - 1, idx2) || solve(str, pattern, idx1, idx2 - 1);
        } else {
            return false;
        }
    }

    public static boolean solveMemo(String s, String p, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 && idx2 < 0) {
            return true;
        }
        if (idx1 >= 0 && idx2 < 0) {
            return false;
        }
        if (idx1 < 0 && idx2 >= 0) {
            for (int k = 0; k <= idx2; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2] == 1;
        }

        boolean result;
        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            result = solveMemo(s, p, idx1 - 1, idx2 - 1, dp);
        } else if (p.charAt(idx2) == '*') {
            result = solveMemo(s, p, idx1, idx2 - 1, dp) || solveMemo(s, p, idx1 - 1, idx2, dp);
        } else {
            return false;
        }

        dp[idx1][idx2] = result ? 1 : 0;
        return result;
    }

    public static boolean solveTab(String s, String p) {
        int dp[][] = new int[s.length() + 1][p.length() + 1];
        dp[0][0] = 1;

        for (int idx2 = 1; idx2 <= p.length(); idx2++) {
            boolean flag = true;
            for (int k = 1; k <= idx2; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][idx2] = flag ? 1 : 0;
        }

        for (int idx1 = 1; idx1 <= s.length(); idx1++) {
            for (int idx2 = 1; idx2 <= p.length(); idx2++) {
                boolean result;
                if (s.charAt(idx1 - 1) == p.charAt(idx2 - 1) || p.charAt(idx2 - 1) == '?') {
                    result = dp[idx1 - 1][idx2 - 1] == 1;
                } else if (p.charAt(idx2 - 1) == '*') {
                    result = dp[idx1][idx2 - 1] == 1 || dp[idx1 - 1][idx2] == 1;
                } else {
                    result = false;
                }

                dp[idx1][idx2] = result ? 1 : 0;
            }
        }

        return dp[s.length()][p.length()] == 1;
    }

    public static boolean solveTabSO(String s, String p) {
        int prev[] = new int[p.length() + 1];
        int curr[] = new int[p.length() + 1];

        prev[0] = 1;
        for (int idx2 = 1; idx2 <= p.length(); idx2++) {
            boolean flag = true;
            for (int k = 1; k <= idx2; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[idx2] = flag ? 1 : 0;
        }

        for (int idx1 = 1; idx1 <= s.length(); idx1++) {
            for (int idx2 = 1; idx2 <= p.length(); idx2++) {
                boolean result;
                if (s.charAt(idx1 - 1) == p.charAt(idx2 - 1) || p.charAt(idx2 - 1) == '?') {
                    result = prev[idx2 - 1] == 1;
                } else if (p.charAt(idx2 - 1) == '*') {
                    result = curr[idx2 - 1] == 1 || prev[idx2] == 1;
                } else {
                    result = false;
                }

                curr[idx2] = result ? 1 : 0;
            }

            prev = curr.clone();
        }

        return prev[p.length()] == 1;
    }

    public static boolean isMatch(String s, String p) {
        // return solve(s, p, s.length() - 1, p.length() - 1);
        // int[][] dp = new int[s.length()][p.length()];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveMemo(s, p, s.length() - 1, p.length() - 1, dp);
        return solveTabSO(s, p);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
    }
}