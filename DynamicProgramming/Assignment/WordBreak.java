import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static boolean check(List<String> wordDict, String word) {
        for (String string : wordDict) {
            if (string.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solveUsingRec(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        // one case, make a String
        StringBuilder word = new StringBuilder();
        boolean flag = false;
        for (int i = start; i < s.length(); i++) {
            word.append(s.charAt(i));
            if (check(wordDict, String.valueOf(word))) {
                flag = flag || solveUsingRec(s, wordDict, i + 1);
            }
        }

        return flag;
    }

    public static boolean solveUsingMemo(String s, List<String> wordDict, int start, Boolean dp[]) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        // one case, make a String
        StringBuilder word = new StringBuilder();
        boolean flag = false;
        for (int i = start; i < s.length(); i++) {
            word.append(s.charAt(i));
            if (check(wordDict, String.valueOf(word))) {
                flag = flag || solveUsingMemo(s, wordDict, i + 1, dp);
            }
        }
        dp[start] = flag;
        return dp[start];
    }

    public static boolean solveUsingTabulation(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        Arrays.fill(dp, true);

        for (int start = s.length() - 1; start >= 0; start--) {
            StringBuilder word = new StringBuilder();
            boolean flag = false;
            for (int i = start; i < s.length(); i++) {
                word.append(s.charAt(i));
                if (check(wordDict, String.valueOf(word))) {
                    flag = flag || dp[i + 1];
                }
            }
            dp[start] = flag;
        }

        return dp[0];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Boolean dp[] = new Boolean[s.length()];
        // Arrays.fill(dp, null);
        return solveUsingTabulation(s, wordDict);
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "applepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple");
        wordDict2.add("pen");
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("snad");
        wordDict3.add("snd");
        wordDict3.add("cat");
        System.out.println(wordBreak(s3, wordDict3));
    }
}
