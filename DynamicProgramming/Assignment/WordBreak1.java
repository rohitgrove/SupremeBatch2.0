import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak1 {
    public static boolean check(List<String> wordDict, String word) {
        for (String str : wordDict) {
            if (word.equals(str)) {
                return true;
            }
        }

        return false;
    }

    public static boolean solveUsingRecursion(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        // one case, make a string
        String word = "";
        boolean flag = false;
        for (int i = start; i < s.length(); i++) {
            word += s.charAt(i);
            if (check(wordDict, word)) {
                flag = flag || solveUsingRecursion(s, wordDict, i + 1);
            }
        }

        return flag;
    }

    public static boolean solveUsingMemo(String s, List<String> wordDict, int start, int dp[]) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != -1) {
            return dp[start] == 1;
        }

        // one case, make a string
        String word = "";
        boolean flag = false;
        for (int i = start; i < s.length(); i++) {
            word += s.charAt(i);
            if (check(wordDict, word)) {
                flag = flag || solveUsingMemo(s, wordDict, i + 1, dp);
            }
        }

        dp[start] = flag ? 1 : 0;
        return dp[start] == 1;
    }

    public static boolean solveUsingTabulation(String s, List<String> wordDict) {
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, 1);

        for (int start = s.length() - 1; start >= 0; start--) {
            String word = "";
            boolean flag = false;
            for (int i = start; i < s.length(); i++) {
                word += s.charAt(i);
                if (check(wordDict, word)) {
                    flag = flag || dp[i + 1] == 1;
                }
            }

            dp[start] = flag ? 1 : 0;
        }

        return dp[0] == 1;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // return solveUsingRecursion(s, wordDict, 0);
        // int dp[] = new int[s.length() + 1];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(s, wordDict, 0, dp);
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
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");
        System.out.println(wordBreak(s3, wordDict3));
    }
}
