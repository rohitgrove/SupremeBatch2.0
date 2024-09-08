public class LongestCommonPrefix {
    public static void findLCP(StringBuilder ans, TrieNode root) {
        if (root.isTerminal) {
            return;
        }

        TrieNode child = null;
        if (root.childCount == 1) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    child = root.children[i];
                    break;
                }
            }

            if (child != null) {
                ans.append(child.value);
            }
        } else {
            return;
        }

        findLCP(ans, child);
    }

    public static String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode('-');
        Trie t = new Trie();
        // Insert all strings into the Trie
        for (String str : strs) {
            t.insertWord(root, str);
        }

        StringBuilder ans = new StringBuilder();
        findLCP(ans, root);

        return ans.toString();
    }


    public static void main(String[] args) {
        String strs1[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs1));
        String strs2[] = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs2));
    }
}
