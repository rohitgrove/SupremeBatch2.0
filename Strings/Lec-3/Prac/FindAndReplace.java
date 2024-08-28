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
        List<String> ans = new ArrayList<>(); 
        StringBuilder patternBuilder = new StringBuilder(pattern);
        upadateStringMapping(patternBuilder);

        for (String word : words) {
            StringBuilder tempString = new StringBuilder(word);
            upadateStringMapping(tempString);
            if (tempString.toString().equals(patternBuilder.toString())) {
                ans.add(word);
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
