public class PreviousPermutation {
    public static void previousPermutation(int arr[]) {
        int n = arr.length;

        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            reverse(arr, 0, arr.length);
            return;
        }

        int j = n - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }

        swap(arr, i, j);

        reverse(arr, i + 1, arr.length - 1);
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 7, 2, 3, 5, 6, 8 };
        printArr(arr);
        previousPermutation(arr);
        printArr(arr);
        // output: 3687532
    }
}
