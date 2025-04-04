import java.util.Stack;

public class InsertInSortedStack {
    public static void insertSorted(Stack<Integer> st, int element) {
        // base case
        if (st.isEmpty() || element > st.peek()) {
            st.push(element);
            return;
        }

        // 1 case sambhalna h
        int temp = st.pop();

        // recursion
        insertSorted(st, element);

        // backtrack
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        insertSorted(st, 500);
        System.out.println(st);
    }
}
