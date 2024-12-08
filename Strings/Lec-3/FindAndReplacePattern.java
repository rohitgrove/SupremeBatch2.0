import java.util.List;
import java.util.ArrayList;

public class FindAndReplacePattern {
    // this function normalises all the words and pattern into a similar format
    // so that we can compare them and find the solution
    public static void createMapping(StringBuilder str) {
        // find mapping
        char start = 'a';
        char mapping[] = new char[300];
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
        // firstly normalise the pattern 
        StringBuilder Pattern = new StringBuilder(pattern);
        createMapping(Pattern);
        pattern = Pattern.toString();

        // sarre words k saath khelne h
        for (String word : words) {
            StringBuilder tempString = new StringBuilder(word);
            // normalise tempString
            createMapping(tempString);
            if (tempString.toString().equals(pattern)) {
                // it means, that 'word' wali string was a valid answer
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
