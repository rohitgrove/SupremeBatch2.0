import java.util.Stack;

public class ValidParantheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    if (ch == ')' && st.peek() == '(') {
                        st.pop();
                    } else if (ch == '}' && st.peek() == '{') {
                        st.pop();
                    } else if (ch == ']' && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
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