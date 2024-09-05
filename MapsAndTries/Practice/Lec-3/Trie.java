public class Trie {
    public void insert(TrieNode root, String word) {
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

        insert(child, word.substring(1));
    }

    public boolean search(TrieNode root, String word) {
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

        return search(child, word.substring(1));
    }
}
