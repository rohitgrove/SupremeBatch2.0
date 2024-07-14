import java.util.Stack;

public class InsertAtBottom {
    public static void insertAtBottom(Stack<Integer> st, int element) {
        if (st.empty()) {
            st.push(element);
            return;
        }  

        // 1 case main solve karunga
        int temp = st.pop();

        insertAtBottom(st, element);

        // backtrack
        st.push(temp);
    }   
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(10);
        st.push(20);
        st.push(30);
        int element = 400;

        System.out.println(st);
        insertAtBottom(st, element);
        System.out.println(st);
    } 
}
