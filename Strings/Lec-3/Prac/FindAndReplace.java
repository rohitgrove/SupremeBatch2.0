import java.util.List;
import java.util.ArrayList;

public class FindAndReplace {
    public static void upadateStringMapping(StringBuilder str) {
        char mapping[] = new char[300];
        char start = 'a';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (mapping[ch] == 0) {
                mapping[ch] = start;
                start++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            str.setCharAt(i, mapping[ch]);
        }
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        StringBuilder patternBuilder = new StringBuilder(pattern);
        upadateStringMapping(patternBuilder);

        List<String> ans = new ArrayList<>();
        for (String s : words) {
            StringBuilder curr = new StringBuilder(s);
            upadateStringMapping(curr);
            if (curr.toString().equals(patternBuilder.toString())) {
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
