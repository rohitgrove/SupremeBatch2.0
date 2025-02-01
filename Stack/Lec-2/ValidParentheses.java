import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                // for open bracket-> just push
                st.push(ch);
            } else {
                // clossing bracket
                if (!st.empty()) {
                    if (ch == ')' && st.peek() == '(') {
                        st.pop();
                    } else if (ch == '}' && st.peek() == '{') {
                        st.pop();
                    } else if (ch == ']' && st.peek() == '[') {
                        st.pop();
                    } else {
                        // no match
                        return false;
                    }
                } else {
                    // no match
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));
        String s2 = "()[]{}";
        System.out.println(isValid(s2));
        String s3 = "(]";
        System.out.println(isValid(s3));
        String s4 = "([])";
        System.out.println(isValid(s4));
    }
}