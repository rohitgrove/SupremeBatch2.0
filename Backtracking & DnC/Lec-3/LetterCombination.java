import java.util.List;
import java.util.ArrayList;

public class LetterCombination {
    public static List<String> letterCombinations(String digits) {
        String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        StringBuilder output = new StringBuilder();
        int index = 0;
        List<String> ans = new ArrayList<>();
        solve(mapping, output, index, ans, digits);
        return ans;
    }

    public static void solve(String[] mapping, StringBuilder output, int index, List<String> ans, String digits) {
        if (index >= digits.length()) {
            // output main String ban gyi chuki hogi
            // sotre that string in ans array
            if (output.length() > 0) {
                ans.add(String.valueOf(output));
            }
            return;
        }

        String temp = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            output.append(temp.charAt(i));
            solve(mapping, output, index + 1, ans, digits);
            // Backtracking
            output.deleteCharAt(output.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println(letterCombinations(digits1));
        String digits2 = "2";
        System.out.println(letterCombinations(digits2));
    }
}
