import java.util.Stack;

class Pair {
    public int price;
    public int span;

    public Pair(int price, int span) {
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
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return span;
    }
}