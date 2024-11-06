public class TransposeAMatrix {
    public static void transpose(int arr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void printArray(int arr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 70, 8 },
                { 9, 10, 1, 11 },
                { 12, 24, 46, 89 }
        };
        int row = arr.length;
        int col = arr[0].length;
        transpose(arr, row, col);
        printArray(arr, row, col);
    }
}
