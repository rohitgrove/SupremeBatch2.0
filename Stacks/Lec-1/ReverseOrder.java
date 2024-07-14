import java.util.Stack;

public class ReverseOrder {
    public static void main(String[] args) {
        String str = "hellojee";
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            st.push(ch);
        }

        System.out.println();
        while (!st.empty()) {
            System.out.print(st.peek());
            st.pop();
        }
        System.out.println();
    }    
}
