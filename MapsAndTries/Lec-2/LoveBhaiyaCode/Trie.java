public class Trie {
    // insertion
    public void insertWord(TrieNode root, String word) {
        // System.out.println("recieved word: " + word + " for insertion");
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
        insertWord(child, word.substring(1));
    }

    public boolean searchWord(TrieNode root, String word) {
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
        boolean recursionKaAnswer = searchWord(child, word.substring(1));
        return recursionKaAnswer;
    }

    public void deleteWord(TrieNode root, String word) {
        // base case
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
