import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);        
        st.push(20);        
        st.push(30);
        
        // size check
        System.out.println("Size of stack is: " + st.size());

        // remove
        st.pop();

        // check empty
        if (st.empty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }

        // top
        System.out.println(st.peek());
        System.out.println(st);
    }
}