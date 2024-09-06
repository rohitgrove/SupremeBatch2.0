import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class Pair {
    public String word;
    public int occur;

    public Pair(String word, int occur) {
        this.word = word;
        this.occur = occur;
    }
}

class WordComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.occur == p2.occur) {
            return p1.word.compareTo(p2.word);
        } else {
            return p2.occur - p1.occur;
        }
    }
}

public class TopKFrequentWord {
    public static List<String> topKFrequent(String words[], int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            if (map.containsKey(words[i])) {
                count = map.get(words[i]);
            }
            map.put(words[i], count + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new WordComparator());
        for (String s : map.keySet()) {
            pq.add(new Pair(s, map.get(s)));
        }

        List<String> ans = new ArrayList<>();
        while (k-- > 0) {
            ans.add(pq.poll().word);
        }

        return ans;
    }

    public static void main(String[] args) {
        String words[] = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topKFrequent(words, k));
        String words2[] = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        int k2 = 4;
        System.out.println(topKFrequent(words2, k2));
    }
}
