import java.util.Stack;

public class ValideParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    if (ch == ')' && st.peek() == '(') {
                        st.pop();
                    } else if (ch == ']' && st.peek() == '[') {
                        st.pop();
                    } else if (ch == '}' && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        if (st.size() == 0) {
            return true;            
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));
        String s2 = "()[]{}";
        System.out.println(isValid(s2));
        String s3 = "(]";
        System.out.println(isValid(s3));
    }
}
