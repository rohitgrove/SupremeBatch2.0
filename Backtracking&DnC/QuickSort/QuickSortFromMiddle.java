public class QuickSortFromMiddle {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start + (end - start) / 2];

        int left = start;
        int right = end;

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        quickSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
        int[] arr2 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        quickSort(arr2, 0, arr2.length - 1);
        printArr(arr2);
    }
}