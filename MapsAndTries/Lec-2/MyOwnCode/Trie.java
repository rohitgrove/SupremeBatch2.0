public class Trie {
    TrieNode root;

    private void insertWordUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(i);
        int index = ch - 'a';
        // elment not present and create new element
        if (root.children[index] == null) {
            root.children[index] = new TrieNode(ch);
        }

        insertWordUtil(root.children[index], word, i + 1);
    }

    private boolean searchUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return root.isTerminal;
        }

        char ch =  word.charAt(i);
        int index = ch - 'a';
        if (root.children[index] != null) {
            // present
            return searchUtil(root.children[index], word, i + 1);
        }

        return false;
    }

    private boolean startWithUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return true;
        }

        char ch =  word.charAt(i);
        int index = ch - 'a';
        if (root.children[index] != null) {
            // present
            return searchUtil(root.children[index], word, i + 1);
        }

        return false;
    }

    private void deleteWordUtil(TrieNode root, String word, int i) {
        if (i == word.length()) {
            root.isTerminal = false;
            return;
        }

        char ch = word.charAt(i);
        int index = ch - 'a';

        if (root.children[index] != null) {
            // present
            deleteWordUtil(root.children[index], word, i + 1);
        }
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insertWord(String word) {
        insertWordUtil(root, word, 0);
    }

    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    public void deleteWord(String word) {
        deleteWordUtil(root, word, 0);
    }

    public boolean startWithUtil(String word) {
        return startWithUtil(root, word, 0);
    }
}
