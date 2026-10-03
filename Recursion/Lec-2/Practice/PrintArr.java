public class PrintArr {
    public static void printArr(int arr[], int start, int end) {
        if (start == end) {
            return;
        }

        System.out.print(arr[start] + " ");
        printArr(arr, start + 1, end);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        printArr(arr, 0, arr.length);
    }
}
