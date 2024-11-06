public class Print2DArray {
    public static void printArray(int arr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void colWisePrint(int arr[][], int row, int col) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // iniitialse
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 1, 11 }
        };
        
        printArray(arr, arr.length, arr[0].length);
        colWisePrint(arr, arr.length, arr[0].length);
    }
}