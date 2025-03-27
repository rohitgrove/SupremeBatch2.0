public class Trie {
    TrieNode root;

    public void insertionWord(TrieNode root, String word, int i) {
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

    public boolean searchWord(TrieNode root, String word, int[] i) {
        if (root.isTerminal) {
            return true;
        }
        if (i[0] >= word.length()) {
            return root.isTerminal;
        }

        int index = word.charAt(i[0]) - 'a';

        if (root.children[index] != null) {
            i[0]++;
            return searchWord(root.children[index], word, i);
        }

        return false;
    }

    public boolean startWithUtil(TrieNode root, String word, int i) {
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

    public int search(String word) {
        int i[] = {0};
        boolean gotIt = searchWord(root, word, i);
        return gotIt ? i[0] : -1;
    }

    public boolean startsWith(String prefix) {
        return startWithUtil(root, prefix, 0);
    }
}