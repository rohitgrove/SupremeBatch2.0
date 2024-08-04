public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        
        // Testing the stack operations
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());  // Output should be 2
        System.out.println(myStack.pop());  // Output should be 2
        System.out.println(myStack.empty()); // Output should be false
    }
}
