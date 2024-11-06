public class PrintRowWiseSum {
    public static void rowWiseSum(int arr[][], int row, int col) {
        for (int i = 0; i < row; i++) {

            int sum = 0;

            for (int j = 0; j < col; j++) {

                sum = sum + arr[i][j];

            }

            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 70, 8 },
                { 9, 10, 1, 11 },
                { 12, 24, 46, 89 }
        };
        rowWiseSum(arr, arr.length, arr[0].length);
    }
}
