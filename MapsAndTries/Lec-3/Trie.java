public class Trie {
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
            root.childCount++;
        }

        insertWordUtil(root.children[index], word, i + 1);
    }

    public void insertWord(TrieNode root,String word) {
        insertWordUtil(root, word, 0);
    }
}
