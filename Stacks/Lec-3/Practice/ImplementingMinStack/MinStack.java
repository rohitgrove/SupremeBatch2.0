import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Pair<Integer, Integer>> st = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        if (st.isEmpty()) {
            Pair<Integer,Integer> pair = new Pair<>();
            pair.first = val;
            pair.second = val;
            st.add(pair);
        } else {
            Pair<Integer,Integer> pair = new Pair<>();
            pair.first = val;
            int prevSecond = st.get(st.size() - 1).second;
            pair.second = Math.min(val, prevSecond);
            st.add(pair);
        }
    }

    public void pop() {
        st.remove(st.size() - 1);
    }

    public int top() {
        return st.get(st.size() - 1).first;
    }

    public int getMin() {
        return st.get(st.size() - 1).second;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */