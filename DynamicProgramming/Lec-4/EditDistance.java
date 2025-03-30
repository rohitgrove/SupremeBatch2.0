import java.util.Arrays;

public class EditDistance {
    public static int solveUsingRec(String word1, String word2, int idx1, int idx2) {
        if (idx1 >= word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 >= word2.length()) {
            return word1.length() - idx1;
        }

        int ans;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            ans = solveUsingRec(word1, word2, idx1 + 1, idx2 + 1);
        } else {
            int replace = 1 + solveUsingRec(word1, word2, idx1 + 1, idx2 + 1);
            int insert = 1 + solveUsingRec(word1, word2, idx1, idx2 + 1);
            int deletion = 1 + solveUsingRec(word1, word2, idx1 + 1, idx2);
            ans = Math.min(replace, Math.min(insert, deletion));
        }

        return ans;
    }

    public static int solveUsingMemo(String word1, String word2, int idx1, int idx2, int dp[][]) {
        if (idx1 >= word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 >= word2.length()) {
            return word1.length() - idx1;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        int ans;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            ans = solveUsingMemo(word1, word2, idx1 + 1, idx2 + 1, dp);
        } else {
            int replace = 1 + solveUsingMemo(word1, word2, idx1 + 1, idx2 + 1, dp);
            int insert = 1 + solveUsingMemo(word1, word2, idx1, idx2 + 1, dp);
            int deletion = 1 + solveUsingMemo(word1, word2, idx1 + 1, idx2, dp);
            ans = Math.min(replace, Math.min(insert, deletion));
        }

        dp[idx1][idx2] = ans;
        return dp[idx1][idx2];
    }

    public static int solveUsingTabulation(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int col = 0; col <= word2.length(); col++) {
            dp[word1.length()][col] = word2.length() - col;
        }

        for (int row = 0; row <= word1.length(); row++) {
            dp[row][word2.length()] = word1.length() - row;
        }

        for (int idx1 = word1.length() - 1; idx1 >= 0; idx1--) {
            for (int idx2 = word2.length() - 1; idx2 >= 0; idx2--) {
                int ans;
                if (word1.charAt(idx1) == word2.charAt(idx2)) {
                    ans = dp[idx1 + 1][idx2 + 1];
                } else {
                    int replace = 1 + dp[idx1 + 1][idx2 + 1];
                    int insert = 1 + dp[idx1][idx2 + 1];
                    int deletion = 1 + dp[idx1 + 1][idx2];
                    ans = Math.min(replace, Math.min(insert, deletion));
                }

                dp[idx1][idx2] = ans;
            }
        }

        return dp[0][0];
    }

    public static int solveUsingTabulationSO(String word1, String word2) {
        int[] next = new int[word1.length() + 1];
        int[] curr = new int[word1.length() + 1];

        // iska kuch na kuch toh karna padega, nhi toh galti kardenge - IMP
        // toh mujhe curr col ka last dabbe me word2.length()-j save karna h
        for (int row = 0; row <= word1.length(); row++) {
            next[row] = word1.length() - row;
        }

        for (int idx2 = word2.length() - 1; idx2 >= 0; idx2--) {
            // hr naye column k last dabbe me ans insert karo
            // MOST IMP LINE HAI
            curr[word1.length()] = word2.length() - idx2;
            for (int idx1 = word1.length() - 1; idx1 >= 0; idx1--) {
                int ans;
                if (word1.charAt(idx1) == word2.charAt(idx2)) {
                    ans = next[idx1 + 1];
                } else {
                    int replace = 1 + next[idx1 + 1];
                    int insert = 1 + next[idx1];
                    int deletion = 1 + curr[idx1 + 1];
                    ans = Math.min(replace, Math.min(insert, deletion));
                }

                curr[idx1] = ans;
            }
            // shifting
            next = curr.clone();
        }

        return next[0];
    }

    public static int minDistance(String word1, String word2) {
        // return solveUsingRec(word1, word2, 0, 0);
        // int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solveUsingMemo(word1, word2, 0, 0, dp);

        return solveUsingTabulationSO(word1, word2);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
