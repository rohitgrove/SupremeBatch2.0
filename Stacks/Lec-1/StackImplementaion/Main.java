public class Main {
    public static void main(String[] args) {
        StackImplementation st = new StackImplementation(8);
        st.push(10);
        st.print();
        st.push(20);
        st.print();
        st.push(30);
        st.print();

        System.out.println("Top element: "+st.peek());
        System.out.println("Size of Stack: "+st.size());

        st.pop();
        st.pop();
        st.pop();
        if (st.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not empty");
        }

        // st.push(40);
        // st.print();
        // st.push(50);
        // st.print();
        // st.push(60);
        // st.print();
        // st.push(70);
        // st.print();
        // st.push(80);
        // st.print();

        // st.pop();
        // st.print();
        // st.pop();
        // st.print();
        // st.pop();
        // st.print();
    }
}
