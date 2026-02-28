import java.util.ArrayList;
import java.util.List;

public class SearchWordFromPrefix {
    public static void storeString(TrieNode root, List<String> ans, StringBuilder input, String prefix) {
        if (root.isTerminal == true) {
            // ans store
            ans.add(prefix + input.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            TrieNode next = root.children[index];
            if (next != null) {
                // child present
                input.append(ch);
                // baaki recursion
                storeString(next, ans, input, prefix);
                // backtrack
                input.deleteCharAt(input.length() - 1);
            }
        }
    }

    public static void findPrefixString(TrieNode root, String input, List<String> ans, String prefix) {
        // base case
        if (input.length() == 0) {
            TrieNode lastChar = root;
            storeString(lastChar, ans, new StringBuilder(input), prefix);
            return;
        }

        char ch = input.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            // child present
            child = root.children[index];
        } else {
            return;
        }

        // recursive call
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
