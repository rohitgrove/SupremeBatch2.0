import java.util.Arrays;

public class InterleavingString {
    public static boolean solveUsingRecursion(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        boolean flag = false;

        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            flag = flag || solveUsingRecursion(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            flag = flag || solveUsingRecursion(s1, s2, s3, i, j + 1, k + 1);
        }

        return flag;
    }

    public static boolean solveUsingMemo(String s1, String s2, String s3, int i, int j, int k, int dp[][][]) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k] == 1;
        }

        boolean flag = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            flag = flag || solveUsingMemo(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            flag = flag || solveUsingMemo(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        dp[i][j][k] = flag ? 1 : 0;
        return dp[i][j][k] == 1;
    }

    public static boolean solveUsingTabulation(String s1, String s2, String s3) {
        int dp[][][] = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        dp[s1.length()][s2.length()][s3.length()] = 1;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                for (int k = s3.length(); k >= 0; k--) {
                    if (i == s1.length() && j == s2.length() && k == s3.length()) {
                        continue;
                    }
                    boolean flag = false;
                    if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
                        flag = flag || dp[i + 1][j][k + 1] == 1;
                    }

                    if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
                        flag = flag || dp[i][j + 1][k + 1] == 1;
                    }

                    dp[i][j][k] = flag ? 1 : 0;
                }
            }
        }

        return dp[0][0][0] == 1;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // return solveUsingRecursion(s1, s2, s3, 0, 0, 0);
        // int dp[][][] = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        // for (int[][] group : dp) {
        // for (int[] row : group) {
        // Arrays.fill(row, -1);
        // }
        // }

        // return solveUsingMemo(s1, s2, s3, 0, 0, 0, dp);

        return solveUsingTabulation(s1, s2, s3);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("", "", ""));
    }
}