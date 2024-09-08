public class Trie {
    // insertion
    public void insertionWord(TrieNode root, String word) {
        // base case
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            // present
            child = root.children[index];
        } else {
            // absent
            child = new TrieNode(ch);
            root.children[index] = child; 
        }

        // recursion
        insertionWord(child, word.substring(1));
    }

    public boolean search(TrieNode root, String word) {
        // base case
        if (word.length() == 0) {
            return root.isTerminal;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            // present or found
            child = root.children[index];
        } else {
            // not found
            return false;
        }

        // baaki recursion
        boolean rescursionKaAnswer = search(child, word.substring(1));
        return rescursionKaAnswer;
    }

    public void deleteWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        // 1 case mera
        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            // present
            child = root.children[index];
        } else {
            // not present
            return;
        }

        // baaki recursion tera
        deleteWord(child, word.substring(1));
    }
}
