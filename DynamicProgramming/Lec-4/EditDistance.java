import java.util.Arrays;

public class EditDistance {
    public static int solveUsingRecursion(String word1, int i, String word2, int j) {
        // base case
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 0 + solveUsingRecursion(word1, i + 1, word2, j + 1);
        } else {
            int replace = 1 + solveUsingRecursion(word1, i + 1, word2, j + 1);
            int insert = 1 + solveUsingRecursion(word1, i, word2, j + 1);
            int remove = 1 + solveUsingRecursion(word1, i + 1, word2, j);
            ans = Math.min(insert, Math.min(replace, remove));
        }

        return ans;
    }

    public static int solveUsingMemo(String word1, int i, String word2, int j, int[][] dp) {
        // base case
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 0 + solveUsingMemo(word1, i + 1, word2, j + 1, dp);
        } else {
            int replace = 1 + solveUsingMemo(word1, i + 1, word2, j + 1, dp);
            int insert = 1 + solveUsingMemo(word1, i, word2, j + 1, dp);
            int remove = 1 + solveUsingMemo(word1, i + 1, word2, j, dp);
            ans = Math.min(insert, Math.min(replace, remove));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }

    public static int solveUsingTabulation(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int col = 0; col <= word2.length(); col++) {
            dp[word1.length()][col] = word2.length() - col;
        }
        for (int row = 0; row <= word1.length(); row++) {
            dp[row][word2.length()] = word1.length() - row;
        }

        for (int i_index = word1.length() - 1; i_index >= 0; i_index--) {
            for (int j_index = word2.length() - 1; j_index >= 0; j_index--) {
                int ans = 0;
                if (word1.charAt(i_index) == word2.charAt(j_index)) {
                    ans = 0 + dp[i_index + 1][j_index + 1];
                } else {
                    int replace = 1 + dp[i_index + 1][j_index + 1];
                    int insert = 1 + dp[i_index][j_index + 1];
                    int remove = 1 + dp[i_index + 1][j_index];
                    ans = Math.min(insert, Math.min(remove, replace));
                }
                dp[i_index][j_index] = ans;
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(String word1, String word2) {

        int curr[] = new int[word1.length() + 1];
        int next[] = new int[word1.length() + 1];
        // abhi ke liye bhul jao
        // for (int col = 0; col <= word2.length(); col++) {
        // dp[word1.length()][col] = word2.length() - col;
        // }
        // iska kuch n kuch karna padega, nhi toh galti karenge - IMP
        // toh mujhe curr col ka last dabbe se word2.length() - j save karna hai 
        for (int row = 0; row <= word1.length(); row++) {
            next[row] = word1.length() - row;
        }

        for (int j_index = word2.length() - 1; j_index >= 0; j_index--) {
            // hr naye column k last dabbe me ans insert karo
            // MOST IMP LINE HAI
            curr[word1.length()] = word2.length() - j_index;
            for (int i_index = word1.length() - 1; i_index >= 0; i_index--) {

                int ans = 0;
                if (word1.charAt(i_index) == word2.charAt(j_index)) {
                    ans = 0 + next[i_index + 1];
                } else {
                    int replace = 1 + next[i_index + 1];
                    int insert = 1 + next[i_index];
                    int remove = 1 + curr[i_index + 1];
                    ans = Math.min(insert, Math.min(remove, replace));
                }
                curr[i_index] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static int minDistance(String word1, String word2) {
        // int i = 0;
        // int j = 0;
        // int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        int ans = solveUsingTabulationSO(word1, word2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
