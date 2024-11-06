public class WaveMatrix {
    public static int[] wavePrintColWise(int arr[][], int nRows, int mCols) {
        int res[] = new int[nRows * mCols];
        int j = 0;
        for (int startCol = 0; startCol < mCols; startCol++) {
            // even no of cols -> top to bottom.
            if (startCol % 2 == 0) {
                for (int i = 0; i < nRows; i++) {
                    res[j] = arr[i][startCol];
                    j++;
                }
            } else {
                // odd no of col -> bottom to top.
                for (int i = nRows - 1; i >= 0; i--) {
                    res[j] = arr[i][startCol];
                    j++;
                }
            }
        }

        return res;
    }

    public static int[] wavePrintRowWise(int arr[][], int nRows, int mCols) {
        int res[] = new int[nRows * mCols];
        int j = 0;
        for (int startRow = 0; startRow < nRows; startRow++) {
            // even no of cols -> top to bottom.
            if (startRow % 2 == 0) {
                for (int i = 0; i < mCols; i++) {
                    res[j] = arr[startRow][i];
                    j++;
                }
            } else {
                // odd no of col -> bottom to top.
                for (int i = mCols - 1; i >= 0; i--) {
                    res[j] = arr[startRow][i];
                    j++;
                }
            }
        }

        return res;
    }

    public static void printMatrix(int matrix[]) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        int arrColWise[] = wavePrintColWise(matrix, matrix.length, matrix[0].length);
        printMatrix(arrColWise);

        int arrRowWise[] = wavePrintRowWise(matrix, matrix.length, matrix[0].length);
        printMatrix(arrRowWise);
    }
}
