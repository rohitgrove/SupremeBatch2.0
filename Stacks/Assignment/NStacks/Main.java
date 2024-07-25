public class Main {
    public static void main(String[] args) {
        NStacks st = new NStacks(3, 6);
        st.push(1, 1);
        st.push(10, 1);
        st.push(15, 1);
        st.push(20, 1);
        st.push(30, 1);
        st.push(40, 1);
        st.push(50, 1);

        System.out.println(st.pop(1));
    }
}