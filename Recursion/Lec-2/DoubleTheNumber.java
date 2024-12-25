public class DoubleTheNumber {
    public static void doubleNumber(int arr[], int idx, int size) {
        if (idx >= size) {
            return;
        }

        arr[idx] = arr[idx] * 2;

        doubleNumber(arr, idx + 1, size);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        doubleNumber(arr, 0, arr.length);
        printArr(arr);
    }
}
