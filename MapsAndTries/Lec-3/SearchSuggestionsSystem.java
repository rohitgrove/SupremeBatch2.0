import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    public static List<List<String>> getSuggestions(TrieNode root, String input) {
        List<List<String>> output = new ArrayList<>();
        TrieNode prev = root;
        StringBuilder inputHelper = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char lastChar = input.charAt(i);
            int index = lastChar - 'a';
            TrieNode curr = prev.children[index];

            if (curr == null) {
                break;
            } else {
                List<String> nicheKaAnswer = new ArrayList<>();
                inputHelper.append(lastChar);
                storeString(curr, nicheKaAnswer, inputHelper, "");
                output.add(nicheKaAnswer);
                // important
                prev = curr;
            }
        }

        return output;
    }

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
        System.out.println(getSuggestions(root, "loa"));
    }
}
