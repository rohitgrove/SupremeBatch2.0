import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {

                // current closing bracket

                if (!st.empty() && s.charAt(st.peek()) == '(' && s.charAt(i) == ')') {
                    // balanced case
                    st.pop();
                } else {
                    // unbalanced case
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int endTerminal = s.length();

        while (!st.empty()) {
            int startTerminal = st.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal - 1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);
    }

    public static void main(String[] args) {
        String s1 = "(()";
        System.out.println(longestValidParentheses(s1));
        String s2 = ")()())";
        System.out.println(longestValidParentheses(s2));
        String s3 = "";
        System.out.println(longestValidParentheses(s3));
        String s4 = "()(()";
        System.out.println(longestValidParentheses(s4));
    }
}