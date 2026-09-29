import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {
    public static void createMapping(StringBuilder str) {
        char mapping[] = new char[256];
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
        StringBuilder Pattern = new StringBuilder(pattern);
        createMapping(Pattern);
        List<String> ans = new ArrayList<>();
        pattern = Pattern.toString();

        for (String word : words) {
            StringBuilder tempString = new StringBuilder(word);
            createMapping(tempString);
            if (tempString.toString().equals(pattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String words1[] = { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, pattern1 = "abb";
        System.out.println(findAndReplacePattern(words1, pattern1));
        String words2[] = { "a", "b", "c" }, pattern2 = "a";
        System.out.println(findAndReplacePattern(words2, pattern2));
    }
}
