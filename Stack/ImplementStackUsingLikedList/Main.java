public class Main {
    public static void main(String[] args) {
        // creation
        Stack st = new Stack();

        // push
        st.push(10);
        st.print();

        st.push(20);
        st.print();

        System.out.println("Top element: " + st.peek());
        System.out.println(st.size());

        // st.pop();
        // st.pop();

        // if (st.isEmpty()) {
        //     System.out.println("Stack is empty");
        // } else {
        //     System.out.println("Stack is not empty");
        // }

        st.push(30);
        st.print();

        st.pop();
        st.print();

        st.pop();
        st.print();

        st.pop();
        st.print();
    }
}
