public class Main {
    public static void main(String[] args) {
        TrieNode root = new TrieNode('-');
        Trie t = new Trie();
        t.insertionWord(root, "cater");
        t.insertionWord(root, "care");
        t.insertionWord(root, "com");
        t.insertionWord(root, "lover");
        t.insertionWord(root, "load");
        t.insertionWord(root, "bat");
        t.insertionWord(root, "car");
        t.insertionWord(root, "cat");
        t.insertionWord(root, "lov");

        String word = "lover";
        if (t.search(root, word)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        t.deleteWord(root, word);

        if (t.search(root, word)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
