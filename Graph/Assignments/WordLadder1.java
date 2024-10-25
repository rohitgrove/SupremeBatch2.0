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

        // Flag to check if the endWord is present in the word list.
        Boolean isPresent = false;

        wordSet.addAll(wordList);

        // Check if the endWord is in the word list.
        for (String currWord : wordList) {
            if (endWord.equals(currWord)) {
                isPresent = true;
                break; // If found, break out of the loop.
            }
        }

        // If endWord is not in the list, return 0 as there's no valid transformation.
        if (!isPresent) {
            return 0;
        }

        Queue<String> wordQueue = new LinkedList<>();

        // Start BFS with the beginWord.
        wordQueue.add(beginWord);

        int distance = 0;

        // BFS loop: continue until the queue is empty.
        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            distance++;

            // Process each word in the current level.
            while (size-- != 0) {
                String currWord = wordQueue.poll(); // Get the front word from the queue.
                char[] temp = currWord.toCharArray();

                // Try changing each character in the current word.
                for (int index = 0; index < currWord.length(); index++) {
                    // hr index pr jo value h, usko main 'a' to 'z' se replace karunga
                    char originalCharacter = temp[index];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[index] = ch;

                        String newWord = new String(temp); // Form a new word.

                        // If the new word matches the endWord, return the distance + 1.
                        if (newWord.equals(endWord)) {
                            return distance + 1;
                        }

                        // check in word list
                        if (wordSet.contains(newWord)) {
                            wordQueue.add(newWord);
                            wordSet.remove(newWord);

                            // Print the new word being added to the queue (for debugging).
                            // System.out.println(newWord);
                        }
                    }
                    // bringing back currString to its original state
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