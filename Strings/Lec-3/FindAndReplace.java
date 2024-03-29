import java.util.ArrayList;
import java.util.List;

public class FindAndReplace {
    // This function normalizes all the words and pattern into a similar format
    // so that we can compare them and find the solution
    public static void createUpdateMapping(StringBuilder str) {
        char start = 'a';
        char[] mapping = new char[300];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (mapping[ch] == 0) {
                mapping[ch] = start;
                start++;
            }
        }

        // update String
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            str.setCharAt(i, mapping[ch]);
        }
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        StringBuilder patternBuilder = new StringBuilder(pattern);
        createUpdateMapping(patternBuilder);

        for (String s : words) {
            StringBuilder tempString = new StringBuilder(s);
            createUpdateMapping(tempString);
            if (tempString.toString().equals(patternBuilder.toString())) {
                ans.add(s);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd"};
        String pattern = "abb";

        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(result);  // Output: [mee, aqq]
    }
}
