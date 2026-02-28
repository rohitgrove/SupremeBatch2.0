import java.util.ArrayList;
import java.util.List;

class Pair {
    public int first;
    public int second;
}

public class MinStack {
    List<Pair> st = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        if (st.isEmpty()) {
            Pair p = new Pair();
            p.first = val;
            p.second = val;
            st.add(p);
        } else {
            Pair p = new Pair();
            p.first = val;
            int purnaMin = st.getLast().second;
            p.second = Math.min(purnaMin, val);
            st.add(p);
        }
    }

    public void pop() {
        st.removeLast();
    }

    public int top() {
        Pair rightMostPair = st.getLast();
        return rightMostPair.first;
    }

    public int getMin() {
        Pair rightMostPair = st.getLast();
        return rightMostPair.second;
    }
}