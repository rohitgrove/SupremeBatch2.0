import java.util.Stack;

public class LongestValidParantheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        System.out.println(longestValidParentheses(s1));
        String s2 = ")()())";
        System.out.println(longestValidParentheses(s2));
    }
}
