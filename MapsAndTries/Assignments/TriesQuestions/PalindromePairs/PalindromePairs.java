import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Trie trie = new Trie();

        // Insert all words in reverse order and mark their index in the trie
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            reversed.reverse();
            trie.insert(reversed, i);
        }

        // Find palindrome pairs for each word
        for (int i = 0; i < words.length; i++) {
            List<Integer> myPalindrome = new ArrayList<>();
            trie.search(words[i], myPalindrome);

            for (Integer it : myPalindrome) {
                if (it != -1 && it != i) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(it);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String words1[] = { "abcd", "dcba", "lls", "s", "sssll" };
        System.out.println(palindromePairs(words1));
        String words2[] = { "bat", "tab", "cat" };
        System.out.println(palindromePairs(words2));
    }
}