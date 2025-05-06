import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2BruteForce {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return result;

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean foundShortest = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> localVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String lastWord = path.get(path.size() - 1);

                char[] chars = lastWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);

                            if (newWord.equals(endWord)) {
                                result.add(newPath);
                                foundShortest = true;
                            } else {
                                queue.offer(newPath);
                                localVisited.add(newWord);
                            }
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            visited.addAll(localVisited);
            if (foundShortest)
                break; // Only want the shortest paths
        }

        return result;
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
        System.out.println(findLadders(beginWord, endWord, wordList1));

        List<String> wordList2 = new ArrayList<>();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println(findLadders(beginWord, endWord, wordList2));
    }
}
