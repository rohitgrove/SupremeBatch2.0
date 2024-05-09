public class EditDistance {
    public static int solve(String word1, String word2, int i, int j) {
        // base case
        if (i >= word1.length()) {
            // word1 wali string end hogyi
            // yani word1 ki length may be word 2 se choti h
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            // word 2 end hogya
            // yaaani word 1 ki length may be greater than word2 hai
            return word1.length() - i;
        }
        int ans = 0;

        if (word1.charAt(i) == word2.charAt(j)) {
            // match
            ans = 0 + solve(word1, word2, i + 1, j + 1);
        } else {
            // not match
            // operation perform karo
            // insert
            int option1 = 1 + solve(word1, word2, i, j + 1);
            // remove
            int option2 = 1 + solve(word1, word2, i + 1, j);
            // replace
            int option3 = 1 + solve(word1, word2, i + 1, j + 1);
            ans = Math.min(option1, Math.min(option2, option3));
        }
        return ans;
    }

    public static int minDistance(String word1, String word2) {
        int i = 0;
        int j = 0;
        int ans = solve(word1, word2, i, j);
        return ans;
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
