import java.util.List;
import java.util.ArrayList;

public class FindAndReplacePattern {
    public static void createMapping(StringBuilder str) {
        char start = 'a';
        char mapping[] = new char[300];
        
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
        StringBuilder Pattern = new StringBuilder(pattern);
        createMapping(Pattern);
        pattern = Pattern.toString();

        for (String word : words) {
            StringBuilder tempBuilder = new StringBuilder(word);
            createMapping(tempBuilder);
            if (tempBuilder.toString().equals(pattern)) {
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
