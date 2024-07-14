import java.util.Stack;

public class RevrseAStack {
    public static void reverseStack(Stack <Integer> st) { // tc: O(n)2
        if (st.isEmpty()) {
            return;
        }

        int temp = st.pop();

        reverseStack(st);

        insertAtBottom(st, temp);
    }

    public static void insertAtBottom(Stack<Integer> st, int element) {
        if (st.empty()) {
            st.add(element);
            return;
        }

        int temp = st.pop();

        insertAtBottom(st, element);

        st.add(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);

        reverseStack(st);

        System.out.println(st);
    }    
}
