public class ShiftArray {
    public static void shiftArray(int[] arr, int n) {
        // Store the last element
        int temp = arr[n - 1];

        // Shift elements to the right
        for (int i = n - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }

        // Assign the last element to the first position
        arr[0] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        int n = 6;

        shiftArray(arr, n);
        printArr(arr);
    }
}
