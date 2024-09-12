public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        String word1 = s;
        StringBuilder word2 = new StringBuilder(s);
        word2.reverse(); 
        return solveUsingTabulationSO(word1, word2.toString());
    }

    public static int solveUsingTabulationSO(String word1, String word2) {
        int next[] = new int[word1.length() + 1];
        int curr[] = new int[word1.length() + 1];

        for (int j = word2.length() - 1; j >= 0; j--) {
            for (int i = word1.length() - 1; i >= 0; i--) {
                int ans = 0;
                if (word1.charAt(i) == word2.charAt(j)) {
                    ans = 1 + next[i + 1];
                } else {
                    ans = 0 + Math.max(curr[i + 1], next[i]);
                }

                curr[i] = ans;
            }

            next = curr.clone();
        }

        return curr[0];
    }

    public static void main(String[] args) {
        String s1 = "bbbab";
        System.out.println(longestPalindromeSubseq(s1));
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s2));
    }
}
