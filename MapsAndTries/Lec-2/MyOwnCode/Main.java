public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertWord("cater");
        t.insertWord("care");
        t.insertWord("com");
        t.insertWord("lover");
        t.insertWord("load");
        t.insertWord("bat");
        t.insertWord("car");
        t.insertWord("cat");
        t.insertWord("lov");

        String word = "lover";
        if (t.search(word)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        t.deleteWord(word);

        if (t.search(word)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
