class Trie {
    TrieNode root;

    private void insertUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(i) - 'a';
        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(i));
        }

        insertUtil(root.children[index], word, i + 1);
    }

    private boolean searchUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(i) - 'a';
        if (root.children[index] != null) {
            return searchUtil(root.children[index], word, i + 1);
        }

        return false;
    }

    private boolean startWithUtil(TrieNode root, String prefix, int i) {
        if (i >= prefix.length()) {
            return true;
        }

        int index = prefix.charAt(i) - 'a';
        if (root.children[index] != null) {
            return startWithUtil(root.children[index], prefix, i + 1);
        }
 
        return false;
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        insertUtil(root, word, 0);
    }

    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    public boolean startsWith(String prefix) {
        return startWithUtil(root, prefix, 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */