public class RotateImage {
    public static void reverseVector(int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse -> 2D MATTIX ki ssaari rows ko
        // kitni rows h -> 0 > (n-1)
        for (int i = 0; i < n; i++) {
            // hr row ko reverse krna h
            reverseVector(matrix[i]);
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
        int matrix1[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        rotate(matrix1);
        printArr(matrix1);
        int matrix2[][] = { { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 } };
        rotate(matrix2);
        printArr(matrix2);
    }
}
