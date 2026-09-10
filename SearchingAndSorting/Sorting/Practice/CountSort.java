public class CountSort {
    public static void countSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }

        int count[] = new int[largest + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int idx = 0;
        int i = 0;
        while (idx < count.length) {
            while (count[idx] != 0) {
                arr[i] = idx;
                i++;
                count[idx]--;
            }
            idx++;
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
    }
}
