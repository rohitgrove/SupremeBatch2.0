import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        int pop = -1;
        if (!s2.empty()) {
            pop = s2.peek();
        } else {
            while (!s1.empty()) {
                s2.add(s1.pop());
            }
            pop = s2.peek();
        }
        s2.pop();
        return pop;
    }
    
    public int peek() {
        int peek = -1;
        if (!s2.empty()) {
            peek = s2.peek();
        } else {
            while (!s1.empty()) {
                s2.add(s1.pop());
            }
            peek = s2.peek();
        }

        return peek;
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
