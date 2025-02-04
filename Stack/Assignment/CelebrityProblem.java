import java.util.Stack;

public class CelebrityProblem {
    public static int celebrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        // step1: push all persons into stack
        for (int i = 0; i < mat.length; i++) {
            st.push(i);
        }

        // step2: run discard method, to get a mightBeCelebrity
        while (st.size() != 1) {
            int a = st.pop();
            int b = st.pop();

            // if a knows b
            if (mat[a][b] == 1) {
                // a is not celebrity, b might be
                st.push(b);
            } else {
                // b is not celebrity, a might be
                st.push(a);
            }
        }

        // step 3: check that single person is actually celebrity
        int mightBeCelebrity = st.pop();

        // Cel. should not know anyone.
        for (int i = 0; i < mat.length; i++) {
            if (mat[mightBeCelebrity][i] != 0) {
                return -1;
            }
        }

        // everyone should know Cel.
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mightBeCelebrity] == 0 && i != mightBeCelebrity) {
                return -1;
            }
        }

        // mightBeCelebrity is the Cel.
        return mightBeCelebrity;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        System.out.println(celebrity(mat1));

        int mat2[][] = { { 0, 1 },
                { 1, 0 } };
        System.out.println(celebrity(mat2));
    }
}
