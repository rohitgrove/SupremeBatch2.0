public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("cater");
        t.insert("care");
        t.insert("com");
        t.insert("lover");
        t.insert("load");
        t.insert("bat");
        t.insert("car");
        t.insert("cat");
        t.insert("lov");

        String word = "lov";
        if (t.search(word)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        if (t.startsWith("b")) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}
