class TrieNode {
    public char value;
    public TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    public TrieNode(char val) {
        this.value = val;
        this.isTerminal = false;
        // No need to explicitly set children to null as it's default
    }
}

public class Trie {
    TrieNode root;

    // Insertion of a word
    public void insertionWord(TrieNode root, String word, int i) {
        // Base case: if the index has reached the end of the word
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(i);
        int index = ch - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(ch);
        }

        // Recur for the next character
        insertionWord(root.children[index], word, i + 1);
    }

    // Search for a complete word
    public boolean searchWord(TrieNode root, String word, int i) {
        // Base case: if the index has reached the end of the word
        if (i >= word.length()) {
            return root.isTerminal;
        }

        char ch = word.charAt(i);
        int index = ch - 'a';

        if (root.children[index] != null) {
            return searchWord(root.children[index], word, i + 1);
        }

        return false;
    }

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startWithUtil(TrieNode root, String word, int i) {
        // Base case: if the index has reached the end of the prefix
        if (i >= word.length()) {
            return true;
        }

        int index = word.charAt(i) - 'a';
        if (root.children[index] != null) {
            return startWithUtil(root.children[index], word, i + 1);
        } 

        return false;
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        insertionWord(root, word, 0);
    }

    public boolean search(String word) {
        return searchWord(root, word, 0);
    }

    public boolean startsWith(String prefix) {
        return startWithUtil(root, prefix, 0);
    }
}
