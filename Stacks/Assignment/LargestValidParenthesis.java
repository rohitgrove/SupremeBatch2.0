import java.util.Stack;

public class LargestValidParenthesis {
    public static int longestValidParentheses1(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.empty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    public static int longestValidParentheses2(String s) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(' && ch == ')') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }

        int maxLen = 0;
        int last = s.length();
        while (!st.empty()) {
            int start = st.pop();
            int len = last - start - 1;
            maxLen = Math.max(maxLen, len);
            last = start;
        }

        maxLen = Math.max(maxLen, last);

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        System.out.println(longestValidParentheses2(s1));
        String s2 = ")()())";
        System.out.println(longestValidParentheses2(s2));
    }
}
