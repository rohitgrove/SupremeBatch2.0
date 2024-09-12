import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int solveUsingRecursion(String word1, String word2, int i, int j) {
        if (i == word1.length() || j == word2.length()) {
            return 0;
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 1 + solveUsingRecursion(word1, word2, i + 1, j + 1);
        } else {
            ans = 0 + Math.max(solveUsingRecursion(word1, word2, i + 1, j),
                    solveUsingRecursion(word1, word2, i, j + 1));
        }

        return ans;
    }

    public static int solveUsingMemo(String word1, String word2, int i, int j, int dp[][]) {
        if (i == word1.length() || j == word2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 1 + solveUsingMemo(word1, word2, i + 1, j + 1, dp);
        } else {
            ans = 0 + Math.max(solveUsingMemo(word1, word2, i + 1, j, dp), solveUsingMemo(word1, word2, i, j + 1, dp));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }

    public static int solveUsingTabulation(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (word1.charAt(i) == word2.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    ans = 0 + Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(String word1, String word2) {
        int next[] = new int[word1.length() + 1];
        int curr[] = new int[word1.length() + 1];

        for (int j = word2.length() - 1; j >= 0; j--) {
            for (int i = word1.length() - 1; i >= 0; i--) {
                int ans = 0;
                if (word1.charAt(i) == word2.charAt(j)) {
                    ans = 1 + next[i + 1];
                } else {
                    ans = 0 + Math.max(curr[i + 1], next[i]);
                }

                curr[i] = ans;
            }

            next = curr.clone();
        }

        return curr[0];
    }

    public static int longestCommonSubsequence(String word1, String word2) {
        // int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        return solveUsingTabulationSO(word1, word2);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}