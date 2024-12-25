public class PrintArray {
    public static void printArr(int arr[], int s, int size) {
        // base case
        if (s >= size) {
            return;
        }

        // processing
        System.out.print(arr[s] + " ");

        // recursive call
        printArr(arr, s + 1, size);
    }
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        printArr(arr, 0, arr.length);
    }
}
