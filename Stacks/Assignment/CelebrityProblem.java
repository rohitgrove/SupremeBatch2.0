import java.util.Stack;

public class CelebrityProblem {
    public static int celebrity(int M[][], int n) {
        Stack<Integer> st = new Stack<>();

        // step 1: push all person into person 
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // step 2: run discard method, to get a mighBeCelebrity
        while (st.size() != 1) {
            int a = st.pop();
            int b = st.pop();

            // if a knows b?
            if (M[a][b] == 1) {
                // a is not celebrity. b might be
                st.push(b);
            } else {
                // b is not celebrity. a might be
                st.push(a);
            }
        }

        // step 3: Check that single person is actually celebrity?
        int mighBeCelebrity = st.pop();

        // Cel. should not know anyone.
        for (int i = 0; i < n; i++) {
            if (M[mighBeCelebrity][i] != 0) {
                return -1;
            }
        }

        // everyone should know Cel.
        for (int i = 0; i < n; i++) {
            if (M[i][mighBeCelebrity] == 0 && i != mighBeCelebrity) {
                return -1;
            }
        }

        // mighBeCelebrity
        return mighBeCelebrity;
    }

    public static void main(String[] args) {
        int N = 3, M[][] = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        System.out.println(celebrity(M, N));
    }
}