public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("cater");
        trie.insertWord("care");
        trie.insertWord("com");
        trie.insertWord("load");
        trie.insertWord("lover");
        trie.insertWord("bat");
        trie.insertWord("car");
        trie.insertWord("cat");

        System.out.println("Insertion Done");

        if (trie.searchWord("lover")) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        trie.deleteWord("lover");

        if (trie.searchWord("lover")) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
