import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int solveUsingRecursion(String text1, String text2, int i, int j) {
        // baase case
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        // recursive call
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solveUsingRecursion(text1, text2, i + 1, j + 1);
        } else {
            ans = 0 + Math.max(solveUsingRecursion(text1, text2, i, j + 1),
                    solveUsingRecursion(text1, text2, i + 1, j));
        }

        return ans;
    }

    public static int solveUsingMemo(String text1, String text2, int i, int j, int[][] dp) {
        // baase case
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // recursive call
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solveUsingMemo(text1, text2, i + 1, j + 1, dp);
        } else {
            ans = 0 + Math.max(solveUsingMemo(text1, text2, i, j + 1, dp), solveUsingMemo(text1, text2, i + 1, j, dp));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }

    public static int solveUsingTabulation(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i_index = text1.length() - 1; i_index >= 0; i_index--) {
            for (int j_index = text2.length() - 1; j_index >= 0; j_index--) {
                int ans = 0;
                if (text1.charAt(i_index) == text2.charAt(j_index)) {
                    ans = 1 + dp[i_index + 1][j_index + 1];
                } else {
                    ans = 0 + Math.max(dp[i_index][j_index + 1], dp[i_index + 1][j_index]);
                }
                dp[i_index][j_index] = ans;
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(String text1, String text2) {
        int curr[] = new int[text1.length() + 1];
        int next[] = new int[text1.length() + 1];

        for (int j_index = text2.length() - 1; j_index >= 0; j_index--) {
            for (int i_index = text1.length() - 1; i_index >= 0; i_index--) {
                int ans = 0;
                if (text1.charAt(i_index) == text2.charAt(j_index)) {
                    ans = 1 + next[i_index + 1];
                } else {
                    ans = 0 + Math.max(next[i_index], curr[i_index + 1]);
                }
                curr[i_index] = ans;
            }
            // shifting
            next = curr.clone();
        }
        return next[0];
    }

    public static int solveUsingTabulationSOWithoutChangLoop(String a, String b) {
        int[] currRow = new int[b.length() + 1];
        int[] nextRow = new int[b.length() + 1];
    
        for (int i_index = a.length() - 1; i_index >= 0; i_index--) {
            for (int j_index = b.length() - 1; j_index >= 0; j_index--) {
                int ans = 0;
                if (a.charAt(i_index) == b.charAt(j_index)) {
                    ans = 1 + nextRow[j_index + 1];
                } else {
                    ans = Math.max(currRow[j_index + 1], nextRow[j_index]);
                }
                currRow[j_index] = ans;
            }
            // Shifting
            nextRow = currRow.clone(); // Clone to avoid reference issues
        }
        return nextRow[0];
    }
    

    public static int longestCommonSubsequence(String text1, String text2) {
        // int i = 0;
        // int j = 0;
        // int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        int ans = solveUsingTabulationSOWithoutChangLoop(text1, text2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}