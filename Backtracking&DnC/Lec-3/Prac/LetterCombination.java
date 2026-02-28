import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void solve(String digits, int index, StringBuilder output, String mapping[], List<String> ans) {
        if (index >= digits.length()) {
            if (output.length() >= 0) {
                ans.add(String.valueOf(output));
            }
            return;
        }

        String temp = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            output.append(temp.charAt(i));
            solve(digits, index + 1, output, mapping, ans);
            output.deleteCharAt(output.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int index = 0;
        StringBuilder output = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(digits, index, output, mapping, ans);
        return ans;
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println(letterCombinations(digits1));
        String digits2 = "2";
        System.out.println(letterCombinations(digits2));
    }
}