public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        // Performing the operations
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // Expected output: 1
        System.out.println(queue.pop());   // Expected output: 1
        System.out.println(queue.empty()); // Expected output: false
    }    
}
