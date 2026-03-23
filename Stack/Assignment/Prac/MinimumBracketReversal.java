import java.util.Stack;

public class MinimumBracketReversal {
    public static int countRev(String str) {
        if (str.length() % 2 != 0) {
            return -1;
        }

        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
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