import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.add(x);
        } else {
            while (!s1.empty()) {
                s2.add(s1.pop());
            }
            s1.add(x);
            while (!s2.empty()) {
                s1.add(s2.pop());
            }
        }
    }

    public int pop() {
        if (s1.isEmpty()) {
            return -1;
        } else {
            return s1.pop();
        }
    }

    public int peek() {
        if (s1.isEmpty()) {
            return -1; 
        } else {
            return s1.peek();
        }
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
