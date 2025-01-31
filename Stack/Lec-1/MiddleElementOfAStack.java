import java.util.Stack;

public class MiddleElementOfAStack {
    public static int ans;

    public static void solve(Stack<Integer> st, int pos) {
        // Base case
        if (pos == 1) {
            ans = st.peek();
            return;
        }

        // 1 case hum solve karenge
        int temp = st.pop();

        // Recursion call
        solve(st, pos - 1);

        // Backtrack
        st.push(temp);
    }

    public static int getMiddleElement(Stack<Integer> st) {
        int size = st.size();
        if (st.isEmpty()) {
            System.out.println("Stack is empty, no middle element");
            return -1;
        } else {
            // stack is not empty
            // odd
            int pos;
            if (size % 2 != 0) {
                pos = size / 2 + 1;
            } else {
                // even
                pos = size / 2;
            }
            ans = -1;
            solve(st, pos);
            return ans;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println("Middle element: " + getMiddleElement(st));
    }
}