import java.util.List;

public class Trie {
    TrieNode root;

    // Insertion of a word
    public void insertionWord(TrieNode root, StringBuilder word, int i, int stringNumber) {
        if (i >= word.length()) {
            root.stringNumber = stringNumber;
            return;
        }

        char ch = word.charAt(i);
        int index = ch - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(ch);
        }

        // Recur for the next character
        insertionWord(root.children[index], word, i + 1, stringNumber);
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(StringBuilder word, int stringNumber) {
        insertionWord(root, word, 0, stringNumber);
    }

    public static boolean isPalindrome(String word, int low, int high) {
        while (low <= high) {
            if (word.charAt(low) != word.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public void search(String word, List<Integer> myPalindrome) {
        TrieNode curr = root;

        // Case 1: When a prefix of String word exactly matches with a word in the trie
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.stringNumber != -1) {
                // Check if the rest of the search-word is a palindrome
                if (isPalindrome(word, i, word.length() - 1)) {
                    myPalindrome.add(curr.stringNumber);
                }
            }

            if (curr.children[index] != null) {
                curr = curr.children[index];
            } else {
                return;
            }
        }

        // Case 2: The search-word is a prefix of a word in the trie
        searchCase2(curr, myPalindrome, new StringBuilder());
    }

    public void searchCase2(TrieNode root, List<Integer> myPalindrome, StringBuilder s) {
        if (root.stringNumber != -1) {
            if (isPalindrome(s.toString(), 0, s.length() - 1)) {
                myPalindrome.add(root.stringNumber);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                s.append((char) (i + 'a'));
                searchCase2(root.children[i], myPalindrome, s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}