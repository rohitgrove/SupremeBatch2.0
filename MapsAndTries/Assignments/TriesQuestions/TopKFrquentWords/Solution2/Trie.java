import java.util.PriorityQueue;

public class Trie {
    TrieNode root;

    public void traverseUtil(TrieNode root, StringBuilder s, int k, PriorityQueue<Pair> pq) {
        if (root == null) {
            return;
        }

        if (root.isTerminal) {
            pq.offer(new Pair(root.freq, s.toString()));
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                s.append((char) (i + 'a'));
                traverseUtil(root.children[i], s, k, pq);
                s.deleteCharAt(s.length() - 1); // backtracking
            }
        }
    }

    public void insertionWord(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isTerminal = true;
            root.freq++;
            return;
        }

        int index = word.charAt(i) - 'a';

        if (root.children[index] == null) {
            root.children[index] = new TrieNode(word.charAt(i));
        }

        insertionWord(root.children[index], word, i + 1);
    }

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        insertionWord(root, word, 0);
    }

    public void traveral(PriorityQueue<Pair> pq, int k) {
        StringBuilder s = new StringBuilder();
        traverseUtil(root, s, k, pq);
    }
}