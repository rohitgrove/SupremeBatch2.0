import java.util.Arrays;

public class DsitinctSubsequence {
    public static int solveUsingRec(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += solveUsingRec(s, t, i + 1, j + 1);
        } 

        ans += solveUsingRec(s, t, i + 1, j);
        return ans;
    }

    public static int solveUsingMemo(String s, String t, int i, int j, int dp[][]) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += solveUsingMemo(s, t, i + 1, j + 1, dp);
        }

        ans += solveUsingMemo(s, t, i + 1, j, dp);

        dp[i][j] = ans;
        return dp[i][j];
    }

    public static int solveUsingTabulation(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }

        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = t.length() - 1; j >= 0; --j) {
                int ans = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    ans += dp[i + 1][j + 1];
                }
        
                ans += dp[i + 1][j];
        
                dp[i][j] = ans;
            }
        }        

        return dp[0][0];
    }

    public static int numDistinct(String s, String t) {
        return solveUsingTabulation(s, t);
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
