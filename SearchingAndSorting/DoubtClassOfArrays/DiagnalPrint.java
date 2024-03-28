public class DiagnalPrint {
    public static int[] diagonalTraversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Invalid matrix");
            return new int[-1];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int res[] = new int[rows * cols];
        int idx = 0;

        for (int diagonal = 0; diagonal < rows + cols - 1; diagonal++) {
            if (diagonal % 2 == 0) { // Upward traversal
                for (int i = Math.min(diagonal, rows - 1); i >= 0 && diagonal - i < cols; i--) {
                    res[idx] = matrix[i][diagonal - i];
                    idx++;
                }
            } else { // Downward traversal
                for (int i = Math.min(diagonal, cols - 1); i >= 0 && diagonal - i < rows; i--) {
                    res[idx] = matrix[diagonal - i][i];
                    idx++;
                }
            }
        }

        return res;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        printArr(diagonalTraversal(mat1));

        int mat2[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printArr(diagonalTraversal(mat2));
    }
}
