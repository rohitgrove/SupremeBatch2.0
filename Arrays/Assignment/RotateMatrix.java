public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int r = 0; r < row; r++) {
            // transpose loop
            for (int c = r; c < col; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }

            // reverse A Row
            int s = 0;
            int e = col - 1;
            while (s < e) {
                int temp = matrix[r][s];
                matrix[r][s] = matrix[r][e];
                matrix[r][e] = temp;
                s++;
                e--;
            }
        }
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printArr(matrix);
        rotate(matrix);
        printArr(matrix);
    }
}