import java.util.Stack;

public class MinimumAddToMakeValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // match found
                st.push(ch);
                ans++;
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    ans--;
                    st.pop();
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s1 = "())";
        System.out.println(minAddToMakeValid(s1));
        String s2 = "(((";
        System.out.println(minAddToMakeValid(s2));
    }   
}
