import java.util.Stack;

public class InsertAtBottom {
    public static void insertAtBottom(Stack<Integer> st, int data) {
        if (st.isEmpty()) {
            st.add(data);
            return;
        }

        int temp = st.peek();
        st.pop();

        insertAtBottom(st, data);

        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        insertAtBottom(st, 400);
        System.out.println(st);
    }
}