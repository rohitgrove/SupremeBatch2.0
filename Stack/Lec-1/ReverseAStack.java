import java.util.Stack;

public class ReverseAStack {
    public static void insertAtBottom(Stack<Integer> st, int data) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }

        int temp = st.peek();
        st.pop();

        insertAtBottom(st, data);

        st.push(temp);
    }

    public static void reverseStack(Stack<Integer> st) {
        // base case
        if (st.isEmpty()) {
            return;
        }

        int temp = st.peek();
        st.pop();

        // recursion
        reverseStack(st);

        insertAtBottom(st, temp);
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
