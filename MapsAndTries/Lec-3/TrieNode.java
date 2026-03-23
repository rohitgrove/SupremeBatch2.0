public class TrieNode {
    public char value;
    public TrieNode children[] = new TrieNode[26];
    public boolean isTerminal;
    public int childCount;

    public TrieNode(char value) {
        this.value = value;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.isTerminal = false;
        this.childCount = 0;
    }
}