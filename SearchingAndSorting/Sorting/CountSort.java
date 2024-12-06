public class CountSort {
    public static void countSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int counts[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        int i = 0;
        int j = 0;
        while (i < counts.length) {
            while (counts[i]-- > 0) {
                arr[j] = i;
                j++;
            }
            i++;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 4, 3, 2, 1 };
        countSort(arr1);
        printArr(arr1);
        int arr2[] = { 44, 33, 55, 22, 11 };
        countSort(arr2);
        printArr(arr2);
        int arr3[] = { 5, 3, 0, 1, 33, 56, 4 };
        countSort(arr3);
        printArr(arr3);
        int arr4[] = { 10, 1, 7, 6, 14, 9 };
        countSort(arr4);
        printArr(arr4);
    }
}
