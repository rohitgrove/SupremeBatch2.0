import java.util.Stack;

class Pair {
    public int span;
    public int price;

    public Pair(int span, int price) {
        this.price = price;
        this.span = span;
    }
}

public class StockSpanner {
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek().price <= price) {
            span += st.peek().span;
            st.pop();
        }
        st.add(new Pair(span, price));
        return span;
    }
}
