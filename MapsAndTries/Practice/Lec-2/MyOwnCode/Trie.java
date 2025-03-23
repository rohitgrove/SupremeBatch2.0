public class Trie {
    public void insertWordUtil(TrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(idx) - 'a';
        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(idx));
        }

        insertWordUtil(root.children[index], word, idx + 1);
    }

    public boolean searchWordUtil(TrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(idx) - 'a';
        if (root.children[index] != null) {
            return searchWordUtil(root.children[index], word, idx + 1);
        }

        return false;
    }

    public void deleteWordUtil(TrieNode root, String word, int idx) {
        if (idx >= word.length()) {
            root.isTerminal = false;
            return;
        }

        int index = word.charAt(idx) - 'a';
        if (root.children[index] != null) {
            deleteWordUtil(root.children[index], word, idx + 1);
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode('-');
    }

    public void insertWord(String word) {
        insertWordUtil(root, word, 0);
    }

    public boolean searchWord(String word) {
        return searchWordUtil(root, word, 0);
    }

    public void deleteWord(String word) {
        deleteWordUtil(root, word, 0);
    }
}
