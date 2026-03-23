import java.util.Arrays;

public class LongestPalindomicSubstring {
    static int maxlen, start;

    public static boolean solveUsingRecursion(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        boolean flag = false;

        if (s.charAt(i) == s.charAt(j)) {
            flag = solveUsingRecursion(s, i + 1, j - 1);
        }

        if (flag) {
            int currlen = j - i + 1;
            if (currlen > maxlen) {
                maxlen = currlen;
                start = i;
            }
        }

        return flag;
    }

    public static boolean solveUsingMemo(String s, int i, int j, Boolean dp[][]) {
        if (i >= j) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean flag = false;

        if (s.charAt(i) == s.charAt(j)) {
            flag = solveUsingMemo(s, i + 1, j - 1, dp);
        }

        if (flag) {
            int currlen = j - i + 1;
            if (currlen > maxlen) {
                maxlen = currlen;
                start = i;
            }
        }

        dp[i][j] = flag;
        return dp[i][j];
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        maxlen = 1;
        start = 0;
        Boolean dp[][] = new Boolean[n + 1][n + 1];

        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                solveUsingMemo(s, i, j, dp);
            }
        }

        return s.substring(start, start + maxlen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
