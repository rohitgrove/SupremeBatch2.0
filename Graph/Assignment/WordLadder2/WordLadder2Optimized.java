import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2Optimized {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }

        HashMap<String, List<String>> parents = new HashMap<>();
        for (String w : words) {
            parents.put(w, new ArrayList<>());
        }

        HashMap<String, Integer> distance = new HashMap<>(); // distance from one word to beginWord
        distance.put(beginWord, 0);

        boolean found = bfs(beginWord, endWord, words, distance, parents);

        if (found) { // if endWord has been found
            dfs(endWord, beginWord, endWord, parents, res, new ArrayList<>());
        }

        return res;

    } // end findLadders

    // BFS: build a graph "parents", also updates "distance" during the process.
    public static boolean bfs(String beginWord, String endWord, Set<String> words, HashMap<String, Integer> distance, HashMap<String, List<String>> parents) {
        boolean found = false;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 0;

        while (!q.isEmpty() && !found) {
            level++;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                String word = q.poll();
                List<String> nexts = getNexts(word, words);
                for (String next : nexts) {
                    if (next.equals(endWord)) {
                        found = true;
                    }
                    if (!distance.containsKey(next)) { // if "next" has not been visited before
                        q.offer(next);
                        distance.put(next, level);
                        parents.get(next).add(word);
                    } else if (distance.get(next) == distance.get(word) + 1) { // if "next" has been visited before, but
                                                                               // in current level
                        // No need to add to queue again, because it has been appeared in this level
                        parents.get(next).add(word);
                    } else {
                        // the "next" has appeared before in smaller level, do nothing
                    }
                } // end for
            } // end for
        } // end while

        return found;
    } // end bfs

    public static List<String> getNexts(String word, Set<String> words) {
        List<String> nexts = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (chs[i] == c)
                    continue;
                char tmp = chs[i];
                chs[i] = c;
                String newWord = String.valueOf(chs);
                if (words.contains(newWord)) {
                    nexts.add(newWord);
                }
                chs[i] = tmp;
            }
        } // end for
        return nexts;
    } // end getNexts

    // DFS: search paths
    public static void dfs(String word, String beginWord, String endWord, HashMap<String, List<String>> parents, List<List<String>> res, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }
        if (word.equals(endWord)) {
            path.add(endWord);
        }
        for (String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, endWord, parents, res, path);
            path.remove(path.size() - 1);
        }
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
