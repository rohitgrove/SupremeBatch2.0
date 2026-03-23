import java.util.Stack;

public class MinimumBracketReversal {
    public static int countRev(String s) {
        // if odd sized string then imposible to make pairs
        if (s.length() % 2 != 0) {
            return -1;
        }

        int ans = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                st.push(ch);
            } else {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        // if stack is still not empty, let's count reverals.
        while (!st.isEmpty()) {
            char a = st.pop();
            char b = st.pop();
            if (a == b) {
                ans += 1;
            } else {
                ans += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "}{{}}{{{";
        System.out.println(countRev(str1));
        String str2 = "{{}{{{}{{}}{{";
        System.out.println(countRev(str2));
    }
}