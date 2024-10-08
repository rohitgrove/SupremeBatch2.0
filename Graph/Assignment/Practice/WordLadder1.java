import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder1 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();

        Boolean isPresent = false;

        wordSet.addAll(wordList);

        for (String currWord : wordList) {
            if (endWord.equals(currWord)) {
                isPresent = true;
                break;
            }
        }

        if (!isPresent) {
            return 0;
        }

        Queue<String> wordQueue = new LinkedList<>();

        wordQueue.add(beginWord);

        int distance = 0;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            distance++;

            while (size-- != 0) {
                String currWord = wordQueue.poll();
                char[] temp = currWord.toCharArray();

                for (int index = 0; index < currWord.length(); index++) {
                    char originalCharacter = temp[index];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[index] = ch;

                        String newWord = new String(temp);

                        if (newWord.equals(endWord)) {
                            return distance + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            wordQueue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    temp[index] = originalCharacter;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord1 = "hit", endWord1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord1, endWord1, wordList1));

        String beginWord2 = "hit", endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(ladderLength(beginWord2, endWord2, wordList2));
    }
}
