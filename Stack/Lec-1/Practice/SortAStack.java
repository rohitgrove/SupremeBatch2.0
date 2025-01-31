import java.util.Stack;

public class SortAStack {
    public static void insertInSortedStack(Stack<Integer> st, int data) {
        if (st.isEmpty() || data > st.peek()) {
            st.push(data);
            return;
        }

        int temp = st.pop();

        insertInSortedStack(st, data);

        st.push(temp);
    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int temp = st.pop();

        sortStack(st);

        insertInSortedStack(st, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(5);
        st.push(12);
        st.push(8);
        st.push(9);
        System.out.println(st);
        sortStack(st);
        System.out.println(st);
    }
}
