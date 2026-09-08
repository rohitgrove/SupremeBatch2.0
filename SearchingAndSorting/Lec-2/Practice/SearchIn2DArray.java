public class SearchIn2DArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int matrixSize = rowSize * colSize;

        int start = 0;
        int end = matrixSize - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            int rowIdx = mid / colSize;
            int colIdx = mid % colSize;
            int currNum = matrix[rowIdx][colIdx];
            if (currNum == target) {
                return true;
            } else if (target > currNum) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }
}
