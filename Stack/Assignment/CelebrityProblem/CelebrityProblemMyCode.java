public class CelebrityProblemMyCode {
    public static boolean knows(int A, int B, int mat[][]) {
        return mat[A][B] == 1;
    }

    public static int findCelebrity(int n, int mat[][]) {
        int candiate = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, candiate, mat)) {
                candiate = i;
            }
        }

        for (int j = 0; j < n; j++) {
            if (j == candiate) {
                continue;
            }
            if (!knows(j, candiate, mat) || knows(candiate, j, mat)) {
                return -1;
            }
        }
        return candiate;
    }

    public static int celebrity(int mat[][]) {
        return findCelebrity(mat.length, mat);
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
    }
}
