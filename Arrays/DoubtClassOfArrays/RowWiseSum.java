public class RowWiseSum {
    public static int[] sum(int matrix[][]) {
        int res[] = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            res[i] = sum;
        }

        return res;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Row " + i + " sum: " + arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 5, 7 },
                { 2, 4, 6, 8 },
                { 10, 15, 15, 10 } };
        int res[] = sum(matrix);
        printArr(res);
    }
}