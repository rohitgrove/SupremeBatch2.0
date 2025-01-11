public class MergeSort1 { // tc: O(nlogn), sc: O(n)
    public static int[] mergeSort(int arr[], int s, int e) {
        // base case
        if (s >= e) {
            return new int[] { arr[s] };
        }

        // break
        int mid = s + (e - s) / 2;

        // recursive call for left array
        int left[] = mergeSort(arr, s, mid);
        // recursive call for right array
        int right[] = mergeSort(arr, mid + 1, e);

        // merge 2 sorted arrays
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        // create ans array
        int ans[] = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int ansIndex = 0;

        // actual merge logic here
        // left array is already sorted
        // right array is already sorted
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                ans[ansIndex] = left[leftIndex];
                ansIndex++;
                leftIndex++;
            } else {
                ans[ansIndex] = right[rightIndex];
                ansIndex++;
                rightIndex++;
            }
        }

        // 1st case-> right array exhaust but left array me element abhi bache hue hai
        while (leftIndex < left.length) {
            ans[ansIndex] = left[leftIndex];
            ansIndex++;
            leftIndex++;
        }

        // 2nd case-> left array exhaust but right array me element abhi bache hue hai
        while (rightIndex < right.length) {
            ans[ansIndex] = right[rightIndex];
            ansIndex++;
            rightIndex++;
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 1, 6, 9, 4, 5 };
        printArr(mergeSort(arr1, 0, arr1.length - 1));
        int arr2[] = { 3, 5, 1, 8, 2, 4 };
        printArr(mergeSort(arr2, 0, arr2.length - 1));
        int arr3[] = { 3, 1, 4, 5, 2 };
        printArr(mergeSort(arr3, 0, arr3.length - 1));
        int arr4[] = { 2, 4, 1, 6, 9 };
        printArr(mergeSort(arr4, 0, arr4.length - 1));
        int arr5[] = { 4, 2, 5, 1, 3 };
        printArr(mergeSort(arr5, 0, arr5.length - 1));
        int arr6[] = { 6, 2, 4, 1 };
        printArr(mergeSort(arr6, 0, arr6.length - 1));
        int arr7[] = { 5, 3, 2, 6, 4 };
        printArr(mergeSort(arr7, 0, arr7.length - 1));
        int arr8[] = { 7, 2, 1, 8, 6, 3, 5, 4 };
        printArr(mergeSort(arr8, 0, arr8.length - 1));
        int[] arr9 = { 50, 40, 80, 90, 70, 10, 30, 60, 120 };
        printArr(mergeSort(arr9, 0, arr9.length - 1));
    }
}