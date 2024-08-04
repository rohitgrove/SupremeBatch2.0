import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
    
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
    }
    
    public int pop() {
        if (queue1.isEmpty()) {
            return -1;
        } else {
            return queue1.poll();
        }
    }
    
    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        } else {
            return queue1.peek();
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }    
}