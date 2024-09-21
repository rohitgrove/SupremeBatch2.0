import java.util.Arrays;

public class InterleavingString {
    public static boolean solveUsingRec(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        boolean flag = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            flag = flag || solveUsingRec(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            flag = flag || solveUsingRec(s1, s2, s3, i, j + 1, k + 1);
        }

        return flag;
    }
    
    public static boolean solveUsingMemo(String s1, String s2, String s3, int i, int j, int k, Boolean dp[][][]) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        boolean flag = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            flag = flag || solveUsingMemo(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            flag = flag || solveUsingMemo(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        dp[i][j][k] = flag;
        return dp[i][j][k];
    }

    public static boolean solveUsingTabulation(String s1, String s2, String s3) {
        boolean dp[][][] = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        dp[s1.length()][s2.length()][s3.length()] = true;
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                for (int k = s3.length() ; k >= 0; k--) {
                    if (i == s1.length() && j == s2.length() && k == s3.length()) {
                        continue;
                    }
                    
                    boolean flag = false;
                    if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
                        flag = flag || dp[i + 1][j][k + 1];
                    }
            
                    if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
                        flag = flag || dp[i][j + 1][k + 1];
                    }
            
                    dp[i][j][k] = flag;
                }
            }
        }

        return dp[0][0][0];
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // Boolean dp[][][] = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        // for (Boolean[][] group : dp) {
        //     for (Boolean[] row : group) {
        //         Arrays.fill(row, null);
        //     }
        // }
        // return solveUsingMemo(s1, s2, s3, 0, 0, 0, dp);
        
        return solveUsingTabulation(s1, s2, s3);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
