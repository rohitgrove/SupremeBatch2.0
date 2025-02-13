import java.util.Stack;

public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        int pop;
        if (!st2.isEmpty()) {
            pop = st2.peek();
        } else {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            pop = st2.peek();
        }

        st2.pop();
        return pop;
    }

    public int peek() {
        int front;
        if (!st2.isEmpty()) {
            front = st2.peek();
        } else {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            front = st2.peek();
        }

        return front;
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}