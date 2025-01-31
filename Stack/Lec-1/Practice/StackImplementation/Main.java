public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(8);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        st.pop();
        if (st.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }

        // st.push(10);
        // st.print();
        // st.push(20);
        // st.print();
        // st.push(30);
        // st.print();
        // System.out.println(st.getSize());
    }
}
