public class EditDistance {
    public static int solve(String word1, String word2, int idx1, int idx2) {
        if (idx1 >= word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 >= word2.length()) {
            return word1.length() - idx1;
        }

        int ans;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            ans = solve(word1, word2, idx1 + 1, idx2 + 1);
        } else {
            int insert = 1 + solve(word1, word2, idx1, idx2 + 1);
            int delete = 1 + solve(word1, word2, idx1 + 1, idx2);
            int replace = 1 + solve(word1, word2, idx1 + 1, idx2 + 1);
            ans = Math.min(insert, Math.min(delete, replace));
        }

        return ans;
    }

    public static int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
