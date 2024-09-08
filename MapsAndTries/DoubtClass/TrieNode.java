public class TrieNode {
    public char data;
    public boolean isTerminal;
    public TrieNode children[] = new TrieNode[26];

    public TrieNode(char ch) {
        data = ch;
        isTerminal = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}