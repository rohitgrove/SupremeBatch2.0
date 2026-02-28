import java.util.Arrays;

public class IsSubsequence {
    public static int solveUsingRec(int i, int j, String s, String t) {
        if (i == s.length() || j == t.length()) {
            return 0;
        }

        int ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + solveUsingRec(i + 1, j + 1, s, t);
        } else {
            ans = solveUsingRec(i, j + 1, s, t);
        }

        return ans;
    }

    public static int solveUsingDP(int i, int j, String s, String t, int dp[][]) {
        if (i == s.length() || j == t.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + solveUsingDP(i + 1, j + 1, s, t, dp);
        } else {
            ans = solveUsingDP(i, j + 1, s, t, dp);
        }

        dp[i][j] = ans;

        return dp[i][j];
    }

    
        public static int solveTabu(String s, String t) {
            int dp[][] = new int[s.length() + 1][t.length() + 1];
    
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = t.length() - 1; j >= 0; j--) {
                    int ans = 0;
                    if (s.charAt(i) == t.charAt(j)) {
                        ans = 1 + dp[i + 1][j + 1];
                    } else {
                        ans = dp[i][j + 1];
                    }
    
                    dp[i][j] = ans;
                }
            }
    
            return dp[0][0];
        }

    public static boolean isSubsequence(String s, String t) {
        // int ans = solveUsingRec(0, 0, s, t);
        // int dp[][] = new int[s.length()][t.length()];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // int ans = solveUsingDP(0, 0, s, t, dp);

        int ans = solveTabu(s, t);
        return ans == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}