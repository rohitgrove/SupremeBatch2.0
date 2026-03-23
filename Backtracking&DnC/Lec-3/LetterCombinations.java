import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void solve(String[] mapping, StringBuilder output, int index, List<String> ans, String digits) {
        // base case
        if (index >= digits.length()) {
            // output me string bannn chuki hogi
            // store that string in ans array
            if (output.length() > 0) {
                ans.add(String.valueOf(output));
            }
            return;
        }

        String temp = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            output.append(temp.charAt(i));
            solve(mapping, output, index + 1, ans, digits);
            // backtracking
            output.deleteCharAt(output.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        StringBuilder output = new StringBuilder();
        int index = 0;
        List<String> ans = new ArrayList<>();
        solve(mapping, output, index, ans, digits);
        return ans;
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println(letterCombinations(digits1));
        String digits2 = "2";
        System.out.println(letterCombinations(digits2));
    }
}
