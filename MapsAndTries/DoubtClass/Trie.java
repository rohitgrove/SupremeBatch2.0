public class Trie {
    TrieNode root;

    private void insertionWord(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(i) - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(i));
        }

        insertionWord(root.children[index], word, i + 1);
    }

    private boolean searchWord(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(i) - 'a';

        if (root.children[index] != null) {
            return searchWord(root.children[index], word, i + 1);
        }

        return false;
    }

    private boolean startWithUtil(TrieNode root, String word, int i) {
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