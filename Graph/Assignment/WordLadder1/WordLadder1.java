import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        Set<String> wordSet = new HashSet<>(wordList);
        // jo bhi word queue me insert karunga, toh usko set me se remove krdunga
        wordSet.remove(beginWord);

        while (!q.isEmpty()) {
            Pair front = q.poll();
            String currString = front.node;
            int currCount = front.dist;

            // check kahin destination tak toh nahi pohoch gye
            if (currString.equals(endWord)) {
                return currCount;
            }

            char[] charArray = currString.toCharArray();
            for (int i = 0; i < currString.length(); i++) {
                char originalChar = charArray[i];
                // hr index pr jo value h, usko main 'a' to 'z' se replace karunga
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    charArray[i] = ch;
                    String newWord = new String(charArray);
                    // check in wordList
                    if (wordSet.contains(newWord)) {
                        q.offer(new Pair(newWord, currCount + 1));
                        wordSet.remove(newWord);
                    }
                }
                // bringing back the currString to its original State
                charArray[i] = originalChar;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList1 = new ArrayList<>();
        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("lot");
        wordList1.add("log");
        wordList1.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList1));

        List<String> wordList2 = new ArrayList<>();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println(ladderLength(beginWord, endWord, wordList2));
    }
}