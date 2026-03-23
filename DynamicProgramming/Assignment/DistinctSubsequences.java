import java.util.Arrays;

public class DistinctSubsequences {
    public static int solveUsingRecursion(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += solveUsingRecursion(s, t, i + 1, j + 1);
        }
        ans += solveUsingRecursion(s, t, i + 1, j);

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

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
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

    public static int solveUsingTabulationSO(String s, String t) {
        int curr[] = new int[t.length() + 1];
        int next[] = new int[t.length() + 1];
        curr[t.length()] = 1;
        next[t.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    ans += next[j + 1];
                }
                ans += next[j];
        
                curr[j] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static int numDistinct(String s, String t) {
        // return solveUsingRecursion(s, t, 0, 0);
        // int dp[][] = new int[s.length() + 1][t.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // return solveUsingMemo(s, t, 0, 0, dp);
        return solveUsingTabulationSO(s, t);
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}