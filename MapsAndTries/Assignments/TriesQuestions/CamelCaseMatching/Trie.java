public class Trie {
    TrieNode root;

    public void insertionWordUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(i) - 'A';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(i));
        }

        insertionWordUtil(root.children[index], word, i + 1);
    }

    public boolean searchWordUtil(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(i) - 'A';

        if (root.children[index] != null) {
            return searchWordUtil(root.children[index], word, i + 1);
        } else if (Character.isLowerCase(word.charAt(i))) {
            return searchWordUtil(root, word, i + 1);
        }

        return false;
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
}