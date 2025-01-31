import java.util.Stack;

public class SortAStack {
    public static void insertSorted(Stack<Integer> st, int element) {
        // base case
        if (st.isEmpty() || element > st.peek()) {
            st.push(element);
            return;
        }

        // 1 case sambhalna h
        int temp = st.pop();

        insertSorted(st, element);

        st.push(temp);
    }

    public static void sortStack(Stack<Integer> st) {
        // base case
        if (st.isEmpty()) {
            return;
        }

        // 1 case sambhal
        int temp = st.pop();

        // recursion
        sortStack(st);

        // backtrack
        insertSorted(st, temp);
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
