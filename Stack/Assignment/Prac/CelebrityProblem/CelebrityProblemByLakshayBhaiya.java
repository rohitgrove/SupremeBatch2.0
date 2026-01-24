import java.util.Stack;

public class CelebrityProblemByLakshayBhaiya {
    public static int celebrity(int[][] mat) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            st.push(i);
        }

        while (st.size() != 1) {
            int a = st.pop();
            int b = st.pop();

            if (mat[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int mightBeCelebity = st.pop();

        for (int i = 0; i < mat.length; i++) {
            if (mat[mightBeCelebity][i] != 0) {
                return -1;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mightBeCelebity] == 0 && i != mightBeCelebity) {
                return -1;
            }
        }

        return mightBeCelebity;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(celebrity(mat1));
        int mat2[][] = { { 1, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 1 } };
        System.out.println(celebrity(mat2));
        int mat3[][] = { { 0, 1 },
                { 1, 0 } };
        System.out.println(celebrity(mat3));
    }
}
