import java.util.Arrays;

public class MinimumSCIIDeleteSumForTwoString {
    public static int solveUsingRec(String s1, String s2, int i, int j) {
        int cost = 0;
        if (i == s1.length() || j == s2.length()) {
            // return the sum of ASCII of remaining char of String
            for (int x = i; x < s1.length(); x++)
                cost += s1.charAt(x);
            for (int x = j; x < s2.length(); x++)
                cost += s2.charAt(x);
            return cost;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            cost = solveUsingRec(s1, s2, i + 1, j + 1);
        } else {
            int cost1 = s1.charAt(i) + solveUsingRec(s1, s2, i + 1, j);
            int cost2 = s2.charAt(j) + solveUsingRec(s1, s2, i, j + 1);
            cost = Math.min(cost1, cost2);
        }

        return cost;
    }

    public static int solveUsingMemo(String s1, String s2, int i, int j, int[][] dp) {
        int cost = 0;
        if (i == s1.length() || j == s2.length()) {
            for (int x = i; x < s1.length(); x++) {
                cost += s1.charAt(x);
            }
            for (int x = j; x < s2.length(); x++) {
                cost += s2.charAt(x);
            }

            return cost;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            cost = solveUsingMemo(s1, s2, i + 1, j + 1, dp);
        } else {
            int cost1 = s1.charAt(i) + solveUsingMemo(s1, s2, i + 1, j, dp);
            int cost2 = s2.charAt(j) + solveUsingMemo(s1, s2, i, j + 1, dp);
            cost = Math.min(cost1, cost2);
        }

        dp[i][j] = cost;
        return dp[i][j];
    }

    public static int solveUsingTabulation(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        // Initialize base cases when one of the strings is empty
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = s1.charAt(i) + dp[i + 1][s2.length()];
        }
    
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = s2.charAt(j) + dp[s1.length()][j + 1];
        }
    
        // Fill the dp table for the rest of the cases
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int cost1 = s1.charAt(i) + dp[i + 1][j];
                    int cost2 = s2.charAt(j) + dp[i][j + 1];
                    dp[i][j] = Math.min(cost1, cost2);
                }
            }
        }
    
        return dp[0][0];
    }

    public static int minimumDeleteSum(String s1, String s2) {
        return solveUsingTabulation(s1, s2);
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("sea", "eat"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
