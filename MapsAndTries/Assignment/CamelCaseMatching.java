import java.util.List;
import java.util.ArrayList;

class TrieNode {
    public char value;
    public TrieNode[] children = new TrieNode[58];
    boolean isTerminal;

    public TrieNode(char val) {
        this.value = val;
        for (int i = 0; i < 58; i++) {
            children[i] = null;
        }
        this.isTerminal = false;
    }
}

class Trie {
    TrieNode root;

    // Insertion of a word
    public void insertionWord(TrieNode root, String word, int i) {
        // Base case: if the index has reached the end of the word
        if (i >= word.length()) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(i);
        int index = ch - 'A';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(ch);
        }

        // Recur for the next character
        insertionWord(root.children[index], word, i + 1);
    }

    // Search for a complete word
    public boolean searchWord(TrieNode root, String word, int i) {
        // Base case: if the index has reached the end of the word
        if (i >= word.length()) {
            return root.isTerminal;
        }

        char ch = word.charAt(i);
        int index = ch - 'A';

        if (root.children[index] != null) {
            return searchWord(root.children[index], word, i + 1);
        } else if (Character.isLowerCase(word.charAt(i))) {
            return searchWord(root, word, i + 1);
        }

        return false;
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        insertionWord(root, word, 0);
    }

    public boolean search(String word) {
        return searchWord(root, word, 0);
    }
}

public class CamelCaseMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) { // tc: 
        List<Boolean> ans = new ArrayList<>();
        Trie trie = new Trie();
        trie.insert(pattern);

        for (String query : queries) {
            ans.add(trie.search(query));
        }

        return ans;
    }

    public static void main(String[] args) {
        String queries1[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern1 = "FB";
        System.out.println(camelMatch(queries1, pattern1));
        String queries2[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern2 = "FoBa";
        System.out.println(camelMatch(queries2, pattern2));
        String queries3[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern3 = "FoBaT";
        System.out.println(camelMatch(queries3, pattern3));
    }
}
