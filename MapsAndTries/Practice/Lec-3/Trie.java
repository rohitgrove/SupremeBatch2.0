public class Trie {
    public void insertWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.children[index] = child;
        }

        insertWord(child, word.substring(1));
    }

    public boolean searchWord(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }

        return searchWord(child, word.substring(1));
    }

    public void deleteWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return;
        }

        deleteWord(child, word.substring(1));
    }
}