import java.util.Stack;

public class SortAStack {
    public static void sortAStack(Stack<Integer> st) { // tc: O(n)2
        // base case
        if (st.empty()) {
            return;
        }

        // 1 case
        int top = st.pop();

        // recursion
        sortAStack(st);

        // backtrack
        insertSorted(st, top);
    }

    public static void insertSorted(Stack<Integer> st, int element) {
        if (st.empty() || element > st.peek()) {
            st.push(element);
            return;
        }

        int temp = st.pop();

        insertSorted(st, element);

        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();        
        st1.push(5);
        st1.push(4);
        st1.push(11);
        st1.push(12);
        st1.push(10);
       
        Stack<Integer> st2 = new Stack<>();        
        st2.push(9);
        st2.push(8);
        st2.push(12);
        st2.push(5);
        st2.push(10);

        System.out.println("Before Sorting");
        System.out.println(st1);
        System.out.println(st2);

        sortAStack(st2);
        sortAStack(st1);

        System.out.println("After Sorting");
        System.out.println(st1);
        System.out.println(st2);
    }    
}
