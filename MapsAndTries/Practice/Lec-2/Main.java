public class Main {
    public static void main(String[] args) {
        TrieNode root = new TrieNode('-');
        Trie t = new Trie();
        t.insertion(root, "rohit");
        t.insertion(root, "rahul");
        t.insertion(root, "rohan");
        t.insertion(root, "rajat");

        String word = "rohit";
        System.out.println(t.search(root, word));

        t.deletion(root, word);
        System.out.println(t.search(root, word));
    }
}