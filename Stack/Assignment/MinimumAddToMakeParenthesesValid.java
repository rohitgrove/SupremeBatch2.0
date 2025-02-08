import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValidHelper1(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    if (st.peek() == '(' && ch == ')') {
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

    public static int minAddToMakeValidHelper2(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ans++;
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                    ans--;
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int minAddToMakeValid(String s) {
        return minAddToMakeValidHelper1(s);
    }

    public static void main(String[] args) {
        String s1 = "())";
        System.out.println(minAddToMakeValid(s1));
        String s2 = "(((";
        System.out.println(minAddToMakeValid(s2));
    }
}
