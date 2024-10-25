import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();

        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(endWord)) {
            return results;
        }


        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(beginWord));

        Set<String> visitedInCurrentLevel = new HashSet<>();

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            // Reset visited words for each level
            visitedInCurrentLevel.clear();

            for (int i = 0; i < size; i++) {
                List<String> path = q.poll();
                String currWord = path.get(path.size() - 1);

                // Check if we've reached the endWord
                if (currWord.equals(endWord)) {
                    results.add(new ArrayList<>(path));
                    found = true;
                }

                char[] currCharArray = currWord.toCharArray();
                for (int index = 0; index < currCharArray.length; index++) {
                    char originalCharacter = currCharArray[index];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currCharArray[index] = ch;
                        String newWord = new String(currCharArray);

                        // If the new word is in the wordList and hasn't been visited before
                        if (st.contains(newWord)) {
                            visitedInCurrentLevel.add(newWord);
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            q.add(newPath);
                        }
                    }
                    currCharArray[index] = originalCharacter;
                }
            }

            // words ko remove kardo jo visited ho chuke hai is level main 
            for (String word : visitedInCurrentLevel) {
                st.remove(word);
            }

            // endWord mil gya toh aage search mat karo
            if (found) {
                break;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        String beginWord1 = "hit", endWord1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(findLadders(beginWord1, endWord1, wordList1));

        String beginWord2 = "hit", endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(findLadders(beginWord2, endWord2, wordList2));
    }
}