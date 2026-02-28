public class MergeSort2 {
    public static void merge(int arr[], int s, int e) {
        int mid = (s + e) / 2;

        int lenLeft = mid - s + 1;
        int lenRight = e - mid;

        // create left and right array
        int left[] = new int[lenLeft];
        int right[] = new int[lenRight];

        // copy values from original array to left array
        int k = s;
        // k -> starting index of left array values in original arrya
        for (int i = 0; i < lenLeft; i++) {
            left[i] = arr[k];
            k++;
        }

        // copy values from original array to right array
        k = mid + 1;
        for (int i = 0; i < lenRight; i++) {
            right[i] = arr[k];
            k++;
        }

        // actual merge logic here
        // left array is already sorted
        // right array is already sorted
        int leftIndex = 0;
        int rightIndex = 0;
        // yahi pr galti karte h log
        int mainArrayIndex = s;

        while (leftIndex < lenLeft && rightIndex < lenRight) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[mainArrayIndex] = left[leftIndex];
                mainArrayIndex++;
                leftIndex++;
            } else {
                arr[mainArrayIndex] = right[rightIndex];
                mainArrayIndex++;
                rightIndex++;
            }
        }

        // 2 more cases

        // 1 case -> left array exhaust but right array me element abhi bhi bache hai
        while (rightIndex < lenRight) {
            arr[mainArrayIndex] = right[rightIndex];
            mainArrayIndex++;
            rightIndex++;
        }

        // 2nd case -> rigght array exhaust but left array me element abhi bhi bache hai
        while (leftIndex < lenLeft) {
            arr[mainArrayIndex] = left[leftIndex];
            mainArrayIndex++;
            leftIndex++;
        }
    }

    public static void mergeSort(int arr[], int s, int e) {
        // base case
        if (s >= e) {
            return;
        }
        // break
        int mid = (s + e) / 2;
        // recusive call for left array
        mergeSort(arr, s, mid);
        // recusive call for right array
        mergeSort(arr, mid + 1, e);
        // merge 2 sorted arrays
        merge(arr, s, e);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 5, 1, 8, 2, 4 };
        mergeSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
        int arr2[] = { 3, 1, 4, 5, 2 };
        mergeSort(arr2, 0, arr2.length - 1);
        printArr(arr2);
        int arr3[] = { 2, 4, 1, 6, 9 };
        mergeSort(arr3, 0, arr3.length - 1);
        printArr(arr3);
        int arr4[] = { 4, 2, 5, 1, 3 };
        mergeSort(arr4, 0, arr4.length - 1);
        int arr5[] = { 6, 2, 4, 1 };
        mergeSort(arr5, 0, arr5.length - 1);
        printArr(arr5);
        int arr6[] = { 5, 3, 2, 6, 4 };
        mergeSort(arr6, 0, arr6.length - 1);
        printArr(arr6);
        int arr7[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        mergeSort(arr7, 0, arr7.length - 1);
        printArr(arr7);
        int[] arr8 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        mergeSort(arr8, 0, arr8.length - 1);
        printArr(arr8);
        int arr9[] = { 2, 1, 6, 9, 4, 5 };
        mergeSort(arr9, 0, arr9.length - 1);
        printArr(arr9);
    }
}