public class Trie {
    public void insertion(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isEnd = true;
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

        insertion(child, word.substring(1));
    }

    public boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isEnd;
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

    public void deletion(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isEnd = false;
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

        deletion(child, word.substring(1));
    }
}