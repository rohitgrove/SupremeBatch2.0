import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Pair<Integer,Integer>> st = new ArrayList<>();      
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            // it means, i am intresting first element
            Pair<Integer, Integer> p = new Pair();
            p.first = val;
            p.second = val;
            st.add(p);
        } else {
            Pair<Integer, Integer> p = new Pair();
            p.first = val;
            int puranaMin = st.get(st.size() - 1).second;
            p.second = Math.min(puranaMin, val);
            st.add(p);
        }
    }
    
    public void pop() {
        if (st.size() == 0) {
            throw new RuntimeException("Stack is empty");
        } else {
            st.removeLast();                    
        }
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