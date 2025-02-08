import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    if (ch == ')' && st.peek() == '(') {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }
        }

        return st.size();
    }

    public static void main(String[] args) {
        String s1 = "())";
        System.out.println(minAddToMakeValid(s1));
        String s2 = "(((";
        System.out.println(minAddToMakeValid(s2));
    }
}
