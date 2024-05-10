import java.util.List;
import java.util.ArrayList;

public class KeypadCombination {
    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println(letterCombinations(digits1));
        String digits2 = "2";
        System.out.println(letterCombinations(digits2));
    }

    public static void solve(List<String> ans, StringBuilder output, String digit, int index,String map[]) {
        if (index >= digit.length()) {
            if (!output.isEmpty()) {
                ans.add(String.valueOf(output));
            }
            return;
        }

        String curr = map[digit.charAt(index)-'0'];
        for (int i = 0; i < curr.length(); i++) {
            output.append(curr.charAt(i));
            solve(ans, output, digit, index + 1, map);
            output.deleteCharAt(output.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();   
        StringBuilder output = new StringBuilder();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(ans, output, digits, 0, mapping);
        return ans;
    }
}