import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class WordBreak2 {
    public static List<String> solveUsingRecursion(String s, HashMap<String, Boolean> dict, int i) {
        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int j = i; j < s.length(); j++) {
            word.append(s.charAt(j));

            if (!dict.containsKey(word.toString())) {
                continue;
            }

            // Found a valid word
            List<String> right = solveUsingRecursion(s, dict, j + 1);
            if (j == s.length() - 1) {
                ans.add(word.toString());
            } else {
                for (String eachRightPart : right) {
                    ans.add(word.toString() + " " + eachRightPart);
                }
            }
        }
        return ans;
    }

    static HashMap<Integer, List<String>> dp = new HashMap<>();

    public static List<String> solveUsingMemo(String s, HashMap<String, Boolean> dict, int i) {
        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        for (int j = i; j < s.length(); j++) {
            word.append(s.charAt(j));

            if (!dict.containsKey(word.toString())) {
                continue;
            }

            // Found a valid word
            List<String> right = solveUsingMemo(s, dict, j + 1);
            if (j == s.length() - 1) {
                ans.add(word.toString());
            } else {
                for (String eachRightPart : right) {
                    ans.add(word.toString() + " " + eachRightPart);
                }
            }
        }

        dp.put(i, ans);
        return dp.get(i);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) {
            dict.put(word, true);
        }
        // return solveUsingRecursion(s, dict, 0);
        return solveUsingMemo(s, dict, 0);
    }

    public static void main(String[] args) {
        String s1 = "catsanddog";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("cats");
        wordDict1.add("dog");
        wordDict1.add("sand");
        wordDict1.add("and");
        wordDict1.add("cat");
        System.out.println(wordBreak(s1, wordDict1));
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple");
        wordDict2.add("pen");
        wordDict2.add("applepen");
        wordDict2.add("pine");
        wordDict2.add("pineapple");
        System.out.println(wordBreak(s2, wordDict2));
        String s3 = "catsandog";
        System.out.println(wordBreak(s3, wordDict1));
    }
}
