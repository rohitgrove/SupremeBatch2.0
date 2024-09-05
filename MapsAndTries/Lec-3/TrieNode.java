public class TrieNode {
    char value;
    TrieNode children[] = new TrieNode[26];
    boolean isTerminal;
    int childCount;
    
    public TrieNode(char value) {
        this.value = value;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isTerminal = false;
        childCount = 0;
    }
}