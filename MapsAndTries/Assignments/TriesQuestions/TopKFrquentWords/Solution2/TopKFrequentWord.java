import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWord {
    public static List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Compare());

        trie.traveral(pq, k);

        while (k-- > 0) {
            ans.add(pq.poll().word);
        }

        return ans;
    }

    public static void main(String[] args) {
        String words1[] = { "i", "love", "leetcode", "i", "love", "coding" };
        int k1 = 2;
        System.out.println(topKFrequent(words1, k1));
        String words2[] = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        int k2 = 4;
        System.out.println(topKFrequent(words2, k2));
    }
}