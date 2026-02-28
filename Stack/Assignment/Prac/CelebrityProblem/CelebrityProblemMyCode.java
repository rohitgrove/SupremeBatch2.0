public class CelebrityProblemMyCode {
    public static boolean knows(int a, int b, int mat[][]) {
        return mat[a][b] == 1;
    }

    public static int findCelebrity(int n, int mat[][]) {
        int candiate = 0;

        for (int i = 0; i < n; i++) {
            if (!knows(i, candiate, mat)) {
                candiate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candiate) {
                continue;
            }

            if (!knows(i, candiate, mat) || knows(candiate, i, mat)) {
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
        int mat3[][] = { { 0, 1 },
                { 1, 0 } };
        System.out.println(celebrity(mat3));
    }
}
