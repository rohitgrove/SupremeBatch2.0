import java.util.Stack;

public class RemoveAllAdjacentString {
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek() == ch) {
                // pair up
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String s1 = "abbaca";
        System.out.println(removeDuplicates(s1));
        String s2 = "azxxzy";
        System.out.println(removeDuplicates(s2));
    }
}
