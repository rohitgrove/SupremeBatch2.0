import java.util.Stack;

public class StockSpanner {
    Stack<Pair<Integer, Integer>> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.empty() && st.peek().price <= price) {
            span += st.peek().span;
            st.pop();
        }
        st.push(new Pair<Integer, Integer>(price, span));

        return span;
    }
}