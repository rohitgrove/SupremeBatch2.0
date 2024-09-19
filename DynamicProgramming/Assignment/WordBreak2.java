import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordBreak2 {
    public static List<String> solveUsingRec(String s, HashMap<String, Boolean> dict, int i) {
        if (i == s.length()) {
            return Arrays.asList("");
        }

        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int j = i; j < s.length(); ++j) {
            word.append(s.charAt(j));

            if (!dict.containsKey(word.toString()))
                continue;

            // Found a valid word
            List<String> right = solveUsingRec(s, dict, j + 1);

            for (String eachRightPart : right) {
                String endPart = "";
                if (eachRightPart.length() > 0) {
                    endPart = " " + eachRightPart;
                }

                ans.add(word.toString() + endPart);
            }
        }

        return ans;
    }

    public static List<String> solveUsingMemo(String s, HashMap<String, Boolean> dict, int i, HashMap<Integer, List<String>> dp) {
        if (i == s.length()) {
            return Arrays.asList("");
        }

        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        for (int j = i; j < s.length(); ++j) {
            word.append(s.charAt(j));

            if (!dict.containsKey(word.toString())) {
                continue;
            }

            // Found a valid word
            List<String> right = solveUsingMemo(s, dict, j + 1, dp);

            for (String eachRightPart : right) {
                String endPart = "";
                if (eachRightPart.length() > 0) {
                    endPart = " " + eachRightPart;
                }

                ans.add(word.toString() + endPart);
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

        HashMap<Integer, List<String>> dp = new HashMap<>();

        return solveUsingMemo(s, dict, 0, dp);
    }

    public static void main(String[] args) {
        String s1 = "catsanddog";
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(wordBreak(s3, wordDict3));
    }
}
