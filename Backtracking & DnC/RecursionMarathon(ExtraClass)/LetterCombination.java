import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void solveByStringBuilder(List<String> ans, String[] mapping, String str, int index,
            StringBuilder output) {
        // base case
        if (index >= str.length()) {
            if (!output.isEmpty()) {
                ans.add(String.valueOf(output));
            }
            return;
        }
        String temp = mapping[str.charAt(index) - '0'];

        for (int i = 0; i < temp.length(); i++) {
            output.append(temp.charAt(i));
            solveByStringBuilder(ans, mapping, str, index + 1, output);
            output.deleteCharAt(output.length() - 1);
        }
    }

    public static void solveByString(List<String> ans, String[] mapping, String str, int index, String output) {
        // base case
        if (index >= str.length()) {
            if (!output.isEmpty()) {
                ans.add(String.valueOf(output));
            }
            return;
        }
        String temp = mapping[str.charAt(index) - '0'];

        for (int i = 0; i < temp.length(); i++) {
            solveByString(ans, mapping, str, index + 1, output + temp.charAt(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int index = 0;
        StringBuilder output = new StringBuilder();
        solveByStringBuilder(ans, mapping, digits, index, output);
        return ans;
    }

    public static void main(String args[]) {
        String number = "23";
        System.out.println(letterCombinations(number));
    }
}