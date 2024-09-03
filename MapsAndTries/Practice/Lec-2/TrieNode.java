public class TrieNode {
    char value;
    public TrieNode children[] = new TrieNode[26];
    boolean isEnd;
    
    public TrieNode(char value) {
        this.value = value;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }

        isEnd = false;
    }
}