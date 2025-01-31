import java.util.Stack;

public class StackBasics {
    public static void main(String[] args) {
        // creation
        Stack<Integer> st = new Stack<>();

        // insertion
        st.push(10);
        st.push(20);
        st.push(30);

        // size check
        System.out.println("Size of stack is: " + st.size());

        // remove
        st.pop();

        // check empty
        if (st.empty()) {
            System.out.println("Stack is emtpy");
        } else {
            System.out.println("Stack is not emtpy");
        }

        // top element
        System.out.println(st.peek());
    }
}