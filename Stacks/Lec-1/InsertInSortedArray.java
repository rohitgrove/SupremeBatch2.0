import java.util.Stack;

public class InsertInSortedArray {
    public static void insertSorted(Stack<Integer> st, int element) {
        // base case
        if (st.empty() || element > st.peek()) {
            st.push(element);
            return;
        }

        // 1 case main solve karunga
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
        st.push(40);
        st.push(50);
        int element = 25;

        System.out.println(st);
        insertSorted(st, element);
        System.out.println(st);
    }    
}
