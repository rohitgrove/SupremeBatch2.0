public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        TrieNode root = new TrieNode('-');
        trie.insertWord(root, "cater");
        trie.insertWord(root, "care");
        trie.insertWord(root, "com");
        trie.insertWord(root, "load");
        trie.insertWord(root, "lover");
        trie.insertWord(root, "bat");
        trie.insertWord(root, "car");
        trie.insertWord(root, "cat");

        System.out.println("Insertion Done");

        if (trie.searchWord(root, "lover")) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        trie.deleteWord(root, "lover");

        if (trie.searchWord(root, "lover")) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
