public class BinarySearch2D {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col;

        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            int rowIndex = mid / col;
            int colIndex = mid % col;
            int currNumber = matrix[rowIndex][colIndex];
            
            if (currNumber == target) {
                return true;
            } else if (target > currNumber) {
                // right;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
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
