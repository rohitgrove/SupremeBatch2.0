public class LongestCommonPrefix {
    public static void insertWord(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        char ch = word.charAt(0);
        int index = ch - 'a';
        TrieNode child;
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(ch);
            root.childCount++;
            root.children[index] = child;
        }

        insertWord(child, word.substring(1));
    }

    public static String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode('-');
        // insert all strings
        for (String str : strs) {
            insertWord(root, str);
        }

        StringBuilder ans = new StringBuilder();
        findLCP(ans, root);
        return ans.toString();
    }

    public static void findLCP(StringBuilder ans, TrieNode root) {
        // base case
        if (root.isTerminal == true) {
            return;
        }

        TrieNode child = null;
        // abhi main root node pr hu
        if (root.childCount == 1) {
            // child th jao
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    child = root.children[i];
                }
            }
            // ans me store karwo
            if (child != null) {
                ans.append(child.value);
            }
        } else {
            return;
        }

        // ab recursion ki baari
        findLCP(ans, child);
    }

    public static void main(String[] args) {
        String strs1[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs1));
        String strs2[] = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs2));
    }
}
