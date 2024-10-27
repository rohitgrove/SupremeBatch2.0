import java.util.Arrays;

public class LongestPalindromicSubstring {

    static int maxlen, start;

    public static boolean solveUsingRec(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        boolean flag = false;

        if (s.charAt(i) == s.charAt(j)) {
            flag = solveUsingRec(s, i + 1, j - 1);
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

        boolean flag = false;

        if (dp[i][j] != null) {
            return dp[i][j];
        }

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

        return dp[i][j] = flag;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        maxlen = 1;  
        start = 0;   

        Boolean dp[][] = new Boolean[n][n];
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
        String s1 = "babad";
        System.out.println(longestPalindrome(s1));  // Output could be "bab" or "aba"
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));  // Output will be "bb"
        String s3 = "aaaabaaa";
        System.out.println(longestPalindrome(s3));
        String s4 = "abba";
        System.out.println(longestPalindrome(s4));
    }
}
