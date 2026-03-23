public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(6);
        st.print();
        st.push1(10);
        st.print();
        st.push1(20);
        st.print();
        st.push2(100);
        st.print();
        st.push2(200);
        st.print();
        st.push2(300);
        st.print();
        st.push2(700);
        st.print();
        // st.push1(1000);
        st.pop1();
        st.print();
        st.pop1();
        st.print();
        // st.pop1();
        // st.print();
        st.pop2();
        st.print();
    }
}
