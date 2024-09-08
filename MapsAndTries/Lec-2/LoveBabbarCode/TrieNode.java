public class TrieNode {
    public char value;
    public TrieNode children[] = new TrieNode[26];
    boolean isTerminal;
    
    public TrieNode(char val) {
        this.value = val;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        this.isTerminal = false;
    }
}