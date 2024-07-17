import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s.isEmpty() || s.length() < 2) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(' && s.charAt(i) == ')' ) { 
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }

        int max = 0;
        int end = s.length();
        while (!st.isEmpty()) {
            int start = st.pop();
            max = Math.max(max, end - start - 1);
            end = start;
        }

        max = Math.max(max, end);
        return max;
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