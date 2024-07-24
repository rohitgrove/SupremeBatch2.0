import java.util.Stack;

public class MinimumBracketReversal {
    public static int countRev(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                st.push(ch);
            } else {
                if (!st.empty() && st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        int count = 0;
        while (!st.empty()) {
            char a = st.pop();
            char b = st.pop();
            if (a == b) {
                count += 1;
            } else {
                count += 2;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String S1 = "}{{}}{{{";
        System.out.println(countRev(S1));
        String S2 = "{{}{{{}{{}}{{";
        System.out.println(countRev(S2));
    }
}
