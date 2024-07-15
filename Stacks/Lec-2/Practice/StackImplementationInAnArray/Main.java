public class Main {
    public static void main(String[] args) {
        StackImplementationInAnArray st = new StackImplementationInAnArray(6);   
        st.push1(10);
        st.push1(20);
        st.push1(30);
        st.print();
        st.push2(100);
        st.print();
        st.push2(200);
        st.print();
        st.push2(300);
        st.print();
        // st.push2(400);
        // st.print();
        st.pop1();
        st.pop1();
        st.pop1();
        st.print();
        st.pop2();
        st.print();
        st.pop2();
        st.print();
        st.pop2();
        st.print();
    }
}
