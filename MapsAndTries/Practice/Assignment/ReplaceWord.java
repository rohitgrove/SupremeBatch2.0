import java.util.ArrayList;
import java.util.List;

class TrieNode {
    public char value;
    public TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    public TrieNode(char val) {
        this.value = val;
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
        int index = ch - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(ch);
        }

        // Recur for the next character
        insertionWord(root.children[index], word, i + 1);
    }

    // Search for the shortest prefix of a word
    public int searchWord(TrieNode root, String word, int i) {
        if (i >= word.length() || root.isTerminal) {
            return i;  // return length of the matching prefix
        }

        char ch = word.charAt(i);
        int index = ch - 'a';

        if (root.children[index] != null) {
            return searchWord(root.children[index], word, i + 1);
        }

        return -1;  // no prefix match
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        insertionWord(root, word, 0);
    }

    public int search(String word) {
        return searchWord(root, word, 0);  // return the length of the matched prefix
    }
}

public class ReplaceWord {
    public static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        Trie trie = new Trie();

        // insert dictionary into trie
        for (String root : dictionary) {
            trie.insert(root);
        }

        // process each word in the sentence
        String[] words = sentence.split(" ");
        for (String word : words) {
            int trieMatchIndex = trie.search(word);
            if (trieMatchIndex != -1 && trieMatchIndex > 0) {
                ans.append(word.substring(0, trieMatchIndex));
            } else {
                ans.append(word);
            }
            ans.append(" ");
        }

        // Remove the trailing space and return
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dictionary1 = new ArrayList<>();
        dictionary1.add("rat");
        dictionary1.add("bat");
        dictionary1.add("cat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary1, sentence1));  // Output: "the cat was rat by the bat"

        List<String> dictionary2 = new ArrayList<>();
        dictionary2.add("a");
        dictionary2.add("b");
        dictionary2.add("c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary2, sentence2));  // Output: "a a b c"
    }
}
