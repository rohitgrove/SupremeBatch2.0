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
        int arr[] = { 2, 1, 6, 9, 4, 5 };
        int size = 6;
        int s = 0;
        int e = size - 1;

        System.out.println("Before merge sort: ");
        printArr(arr);

        mergeSort(arr, s, e);

        System.out.println("After merge sort: ");
        printArr(arr);

    }
}