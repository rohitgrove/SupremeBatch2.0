public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = r; c < matrix[0].length; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }

            int l = 0;
            int h = matrix[0].length - 1;
            while (l < h) {
                int temp = matrix[r][l];
                matrix[r][l] = matrix[r][h];
                matrix[r][h] = temp;
                l++;
                h--;
            }
        }
    }

    public static void printArr(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix1[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printArr(matrix1);
        rotate(matrix1);
        printArr(matrix1);

        int matrix2[][] = { { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 } };
        printArr(matrix2);
        rotate(matrix2);
        printArr(matrix2);
    }
}