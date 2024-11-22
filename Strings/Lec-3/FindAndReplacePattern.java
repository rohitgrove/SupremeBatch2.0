import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {
    // This function normalizes all the words and pattern into a similar format
    // so that we can compare them and find the solution
    public static void createUpdateMapping(StringBuilder str) {
        //find mappping
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
        //firstly normalise the pattern
        createUpdateMapping(patternBuilder);
        //saare words k sath khelna h
        for (String s : words) {
            StringBuilder tempString = new StringBuilder(s);
            //normalise tempString
            createUpdateMapping(tempString);
            if (tempString.toString().equals(patternBuilder.toString())) {
                //it means, that "s" wali string was a valid answer
                ans.add(s);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd"};
        String pattern = "abb";

        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(result);
    }
}
