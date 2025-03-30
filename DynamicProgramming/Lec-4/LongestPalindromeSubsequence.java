public class LongestPalindromeSubsequence {
    public static int solveUsingTabulationSO(String text1, String text2) {
        int next[] = new int[text1.length() + 1];
        int curr[] = new int[text1.length() + 1];

        for (int j_Index = text2.length() - 1; j_Index >= 0; j_Index--) {
            for (int i_Index = text1.length() - 1; i_Index >= 0; i_Index--) {
                int ans;
                if (text1.charAt(i_Index) == text2.charAt(j_Index)) {
                    ans = 1 + next[i_Index + 1];
                } else {
                    ans = 0 + Math.max(next[i_Index],
                            curr[i_Index + 1]);
                }
                curr[i_Index] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    public static int longestPalindromeSubseq(String s) {
        StringBuilder text2 = new StringBuilder(s);
        text2.reverse();
        int ans = solveUsingTabulationSO(s, text2.toString());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
