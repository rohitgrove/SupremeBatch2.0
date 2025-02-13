import java.util.Stack;

public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            st1.push(x);
        } else {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }

            st1.push(x);

            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}