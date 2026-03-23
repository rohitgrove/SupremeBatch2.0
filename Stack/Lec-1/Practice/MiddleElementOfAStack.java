import java.util.Stack;

public class MiddleElementOfAStack {
    public static int ans;

    public static void solve(Stack<Integer> st, int pos) {
        if (pos == 1) {
            ans = st.peek();
            return;
        }

        int temp = st.peek();
        st.pop();

        solve(st, pos - 1);

        st.push(temp);
    }

    public static int getMiddleElement(Stack<Integer> st) {
        int size = st.size();
        if (st.isEmpty()) {
            return -1;
        } else {
            int pos;
            if (size % 2 != 0) {
                pos = size / 2 + 1;
            } else {
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
        // st.push(60);
        System.out.println("Middle element: " + getMiddleElement(st));
    }
}