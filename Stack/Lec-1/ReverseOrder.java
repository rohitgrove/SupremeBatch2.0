import java.util.Stack;

public class ReverseOrder {
    public static void main(String[] args) {
        String str = "hellojee";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            st.push(ch);
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }
}
