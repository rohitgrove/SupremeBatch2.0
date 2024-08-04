public class Main {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(4);
        st.print();
        st.push(9);
        st.print();
        st.pop();
        st.print();
        System.out.println(st.size());
        st.push(6);
        st.print();
        st.push(8);
        st.print();
        st.push(10);
        st.print();
        st.push(12);
        st.print();
        System.out.println(st.peek());
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
        st.print();
        st.pop();
    }
}
