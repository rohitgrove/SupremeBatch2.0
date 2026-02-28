import java.util.ArrayList;
import java.util.List;

public class SearchWordFromPrefix {
    public static void storeAnswer(TrieNode root, List<String> ans, StringBuilder input, String prefix) {
        if (root.isTerminal == true) {
            ans.add(prefix + input.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            TrieNode next = root.children[index];
            if (next != null) {
                input.append(ch);
                storeAnswer(next, ans, input, prefix);
                input.deleteCharAt(input.length() - 1);
            }
        }
    }

    public static void findPrefixString(TrieNode root, String input, List<String> ans, String prefix) {
        if (input.length() == 0) {
            TrieNode lastNode = root;
            storeAnswer(lastNode, ans, new StringBuilder(input), prefix);
            return;
        }

        char ch = input.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return;
        }

        findPrefixString(child, input.substring(1), ans, prefix);
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        TrieNode root = new TrieNode('-');
        trie.insertWord(root, "code");
        trie.insertWord(root, "court");
        trie.insertWord(root, "car");
        trie.insertWord(root, "card");
        trie.insertWord(root, "codehelp");
        trie.insertWord(root, "love");
        trie.insertWord(root, "lovely");
        trie.insertWord(root, "dove");
        trie.insertWord(root, "dovey");
        trie.insertWord(root, "babu");
        trie.insertWord(root, "sona");
        trie.insertWord(root, "cutie");
        trie.insertWord(root, "dot");
        trie.insertWord(root, "supra");

        System.out.println("Insertion Done");
        List<String> ans = new ArrayList<>();
        String input = "c";
        String prefix = input;
        findPrefixString(root, input, ans, prefix);
        System.out.println(ans);
    }
}
