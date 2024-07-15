public class Main {
    public static void main(String[] args) {
        ImplementStackWithTwoArrays st = new ImplementStackWithTwoArrays(6);

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

        // st.push2(1000);
        // st.print();

        st.pop1();
        st.print();

        st.pop1();
        st.print();
    }
}
