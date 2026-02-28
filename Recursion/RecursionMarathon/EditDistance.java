public class EditDistance {
    public static int solve(String word1, String word2, int idx1, int idx2) {
        // base case
        if (idx1 >= word1.length()) {
            // word1 wali string wnd hogyi
            // yani word ki length may be 2 se choti ho
            return word2.length() - idx2;
        }

        if (idx2 >= word2.length()) {
            // word2 end ho gyi
            // yaaani word1 ki length may be greater than word2 hai
            return word1.length() - idx1;
        }

        int ans;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            // match
            ans = 0 + solve(word1, word2, idx1 + 1, idx2 + 1);
        } else {
            // not match
            // operation perform karo
            // insert
            int option1 = 1 + solve(word1, word2, idx1, idx2 + 1);
            // remove
            int option2 = 1 + solve(word1, word2, idx1 + 1, idx2);
            // replace
            int option3 = 1 + solve(word1, word2, idx1 + 1, idx2 + 1);
            ans = Math.min(Math.min(option1, option2), option3);
        }
        return ans;
    }

    public static int minDistance(String word1, String word2) {
        int idx1 = 0;
        int idx2 = 0;
        int ans = solve(word1, word2, idx1, idx2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
