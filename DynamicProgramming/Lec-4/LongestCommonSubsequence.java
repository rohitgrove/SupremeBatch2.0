import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int solveUsingRec(String text1, String text2, int i, int j) {
        // base case
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        // recursive call
        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solveUsingRec(text1, text2, i + 1, j + 1);
        } else {
            ans = 0 + Math.max(solveUsingRec(text1, text2, i, j + 1),
                    solveUsingRec(text1, text2, i + 1, j));
        }

        return ans;
    }

    public static int solveUsingMemo(String text1, String text2, int i, int j, int[][] dp) {
        // base case
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        // check if ans already exists
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // recursive call
        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solveUsingMemo(text1, text2, i + 1, j + 1, dp);
        } else {
            ans = 0 + Math.max(solveUsingMemo(text1, text2, i, j + 1, dp),
                    solveUsingMemo(text1, text2, i + 1, j, dp));
        }

        dp[i][j] = ans;
        return ans;
    }

    public static int solveUsingTabulation(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i_Index = text1.length() - 1; i_Index >= 0; i_Index--) {
            for (int j_Index = text2.length() - 1; j_Index >= 0; j_Index--) {
                int ans;
                if (text1.charAt(i_Index) == text2.charAt(j_Index)) {
                    ans = 1 + dp[i_Index + 1][j_Index + 1];
                } else {
                    ans = 0 + Math.max(dp[i_Index][j_Index + 1],
                            dp[i_Index + 1][j_Index]);
                }
                dp[i_Index][j_Index] = ans;
            }
        }

        return dp[0][0];
    }

    // with loop changing
    public static int solveUsingTabulationSO(String text1, String text2) {
        int next[] = new int[text1.length() + 1];
        int curr[] = new int[text1.length() + 1];

        for (int j_Index = text2.length() - 1; j_Index >= 0; j_Index--) {
            for (int i_Index = text1.length() - 1; i_Index >= 0; i_Index--) {
                int ans;
                if (text1.charAt(i_Index) == text2.charAt(j_Index)) {
                    ans = 1 + next[i_Index + 1];
                } else {
                    ans = 0 + Math.max(next[i_Index],
                            curr[i_Index + 1]);
                }
                curr[i_Index] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // int i = 0;
        // int j = 0;
        // int ans = solveUsingRec(text1, text2, i, j);
        // int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(text1, text2, i, j, dp);
        // return ans;

        int ans = solveUsingTabulationSO(text1, text2);
        return ans;
    }

    public static void main(String[] args) {
        System.err.println(longestCommonSubsequence("abcde", "ace"));
        System.err.println(longestCommonSubsequence("abc", "abc"));
        System.err.println(longestCommonSubsequence("abc", "def"));
    }
}