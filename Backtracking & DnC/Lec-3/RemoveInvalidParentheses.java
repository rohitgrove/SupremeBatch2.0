import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class RemoveInvalidParentheses {
    public static void solve(String s, int index, int open, int close, int bal, StringBuilder output, HashSet<String> ans) {
        // base case
        if (index >= s.length()) {
            // valid ans
            if (open == 0 && close == 0 && bal == 0) {
                ans.add(String.valueOf(output));
            }
            return;
        }

        // incl/excl
        if (s.charAt(index) != '(' && s.charAt(index) != ')') {
            // include
            output.append(s.charAt(index));
            solve(s, index + 1, open, close, bal, output, ans);
            output.deleteCharAt(output.length() - 1);
        } else {
            // bracket wala case
            if (s.charAt(index) == '(') {
                // removal - include
                if (open > 0) {
                    solve(s, index + 1, open - 1, close, bal, output, ans);
                }
                // removal - exclude
                output.append(s.charAt(index));
                solve(s, index + 1, open, close, bal + 1, output, ans);
                output.deleteCharAt(output.length() - 1);
            } else if (s.charAt(index) == ')') {
                // removal - include
                if (close > 0) {
                    solve(s, index + 1, open, close - 1, bal, output, ans);
                }
                // removal - exclude
                // removal nahi karna , sirf usi case jab corresponding opening bracket
                // available hai
                if (bal > 0) {
                    output.append(s.charAt(index));
                    solve(s, index + 1, open, close, bal - 1, output, ans);
                    output.deleteCharAt(output.length() - 1);
                }
            }
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        HashSet<String> ans = new HashSet<>();
        int invalidOpen = 0;
        int invalidClose = 0;


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                invalidOpen++;
            if (ch == ')') {
                if (invalidOpen != 0) {
                    --invalidOpen;
                } else {
                    invalidClose++;
                }
            }
        }
        int index = 0;
        int balance = 0;
        StringBuilder output = new StringBuilder();
        solve(s, index, invalidOpen, invalidClose, balance, output, ans);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        String s1 = "()())()";
        System.out.println(removeInvalidParentheses(s1));
        String s2 = "(a)())()";
        System.out.println(removeInvalidParentheses(s2));
        String s3 = ")(";
        System.out.println(removeInvalidParentheses(s3));
    }
}
