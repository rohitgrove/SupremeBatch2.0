import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
    public static List<String> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode('-');
        Trie t = new Trie();

        for (int i = 0; i < products.length; i++) {
            t.insertWord(root, products[i]);
        }

        List<String> ans = new ArrayList<>();
        String prefix = searchWord;
        findPrefixString(root, searchWord, ans, prefix);

        return ans;
    }

    public static List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        TrieNode root = new TrieNode('-');
        Trie t = new Trie();

        for (int i = 0; i < products.length; i++) {
            t.insertWord(root, products[i]);
        }

        return getSuggestions(root, searchWord);
    }

    public static void findPrefixString(TrieNode root, String searchWord, List<String> ans, String prefix) {
        // base case
        if (searchWord.length() == 0) {
            TrieNode lastchar = root;
            storeString(lastchar, ans, new StringBuilder(searchWord), prefix);
            return;
        }

        char ch = searchWord.charAt(0);
        int index = ch - 'a';
        TrieNode child;

        if (root.children[index] != null) {
            // child present
            child = root.children[index];
        } else {
            return;
        }
        // recursive call
        findPrefixString(child, searchWord.substring(1), ans, prefix);
    }

    public static void storeString(TrieNode root, List<String> suffix, StringBuilder input, String prefix) {
        // base case
        if (root.isTerminal == true) {
            // ans store
            suffix.add(prefix + input);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            TrieNode next = root.children[index];
            if (next != null) {
                // child exist
                input.append(ch);
                // baaki recursion
                storeString(next, suffix, input, prefix);
                // backtracking
                input.deleteCharAt(input.length() - 1);
            }
        }
    }

    public static List<List<String>> getSuggestions(TrieNode root, String input) {
        List<List<String>> output = new ArrayList<>();
        TrieNode prev = root;
        String input_Helper = "";

        for (int i = 0; i < input.length(); i++) {
            char lastchar = input.charAt(i);
            int index = lastchar - 'a';
            TrieNode curr = prev.children[index];

            if (curr == null) {
                break;
            } else {
                List<String> nichekaanwser = new ArrayList<>();
                input_Helper += lastchar;
                String dummy = "";
                storeString(curr, nichekaanwser, new StringBuilder(input_Helper), dummy);

                output.add(nichekaanwser);
                // important
                prev = curr;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String products1[] = { "mobile", "mouse", "moneypot", "monitor", "mousepad" }, searchWord1 = "mouse";
        System.out.println(suggestedProducts2(products1, searchWord1));
        String products2[] = { "havana" }, searchWord2 = "havana";
        System.out.println(suggestedProducts2(products2, searchWord2));
        String products3[] = { "cater", "care", "com", "lover", "load", "bat", "car", "cat", "lov" },
                searchWord3 = "lov";
        System.out.println(suggestedProducts2(products3, searchWord3));
    }
}