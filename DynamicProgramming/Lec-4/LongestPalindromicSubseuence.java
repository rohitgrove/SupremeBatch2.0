public class LongestPalindromicSubseuence {
    public static int longestPalindromeSubseq(String s) {
        String a = s; 
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        return solveUsingTabulationSO(str.toString(), a);
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

    public static void main(String[] args) {
        String s1 = "bbbab";
        System.out.println(longestPalindromeSubseq(s1));
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s2));
    }
}
