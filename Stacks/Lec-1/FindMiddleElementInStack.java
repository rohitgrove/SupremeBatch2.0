import java.util.Stack;

public class FindMiddleElementInStack {
    public static void solve(Stack<Integer> st, int pos, int []ans) {
        // base case
        if (pos == 1) {
            ans[0] = st.peek();
            st.pop();
            return;
        }

        // 1 case hum solve karenge
        pos--;
        int temp = st.pop();

        // recursion
        solve(st, pos, ans);

        // backtrack
        st.push(temp);
    }

    public static int getMiddleElement(Stack<Integer> st) {
        int size = st.size();
        if (st.empty()) {
            return -1;
        } else {
            // stack is not empty
            // odd
            int pos = 0;
            if ((size&1) == 1) {
                pos = size / 2 + 1;
            } else {
                // even
                pos = size / 2;
            }

            int ans[] = {-1};
            solve(st, pos, ans);
            return ans[0];
        }
    }  
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        int mid = getMiddleElement(st);
        System.out.println("Middle element: "+mid);
        System.out.println(st);
    }  
}
