import java.util.Stack;

public class CelebrityProblem {
    public static int celebrity(int[][] m, int n) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() != 1) {
            int a = st.pop();
            int b = st.pop();
            if (m[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int mightBeCelebrity = st.pop();

        for (int i = 0; i < n; i++) {
            if (m[mightBeCelebrity][i] != 0) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (m[i][mightBeCelebrity] == 0 && i != mightBeCelebrity) {
                return -1;
            }
        }

        return mightBeCelebrity;
    }

    public static void main(String[] args) {
        int N = 3, M[][] = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        System.out.println(celebrity(M, N));
    }
}
