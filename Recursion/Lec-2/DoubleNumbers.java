public class DoubleNumbers {
    public static void doubleNumbers(int arr[], int index) {
        if (index == arr.length) {
            return;
        }

        arr[index] = arr[index] * 2;
        doubleNumbers(arr, index + 1);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        doubleNumbers(arr, 0);
        printArr(arr);
    }
}
