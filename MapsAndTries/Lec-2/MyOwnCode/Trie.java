public class Trie {
    TrieNode root;

    private void insertionWordUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(i) - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(i));
        }

        insertionWordUtil(root.children[index], word, i + 1);
    }

    private boolean searchWordUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(i) - 'a';

        if (root.children[index] != null) {
            return searchWordUtil(root.children[index], word, i + 1);
        }

        return false;
    }

    private void deleteWordUtil(TrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            root.isTerminal = false;
            return;
        }

        char ch = word.charAt(idx);
        int index = ch - 'a';
        if (root.children[index] != null) {
            deleteWordUtil(root.children[index], word, idx + 1);
        }
    }

    public Trie() {
        root = new TrieNode('-');
    }

    public void insertWord(String word) {
        insertionWordUtil(root, word, 0);
    }

    public boolean searchWord(String word) {
        return searchWordUtil(root, word, 0);
    }

    public void deleteWord(String word) {
        deleteWordUtil(root, word, 0);
    }
}