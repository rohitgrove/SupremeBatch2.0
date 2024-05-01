public class MergeSort {
    public static int[] mergeSort(int[] arr, int s, int e) {
        if (s >= e) {
            int ans[] = new int[1];
            ans[0] = arr[s];
            return ans;
        }

        int mid = s + (e - s) / 2;
        int left[] = mergeSort(arr, s, mid);
        int right[] = mergeSort(arr, mid + 1, e);
        return merge(left, right);
    }

    public static int[] merge(int left[], int right[]) {
        int temp[] = new int[left.length + right.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int tempIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                temp[tempIdx] = left[leftIdx];
                leftIdx++;
                tempIdx++;
            } else {
                temp[tempIdx] = right[rightIdx];
                rightIdx++;
                tempIdx++;
            }
        }

        while (leftIdx < left.length) {
            temp[tempIdx] = left[leftIdx];
            leftIdx++;
            tempIdx++;
        }

        while (rightIdx < right.length) {
            temp[tempIdx] = right[rightIdx];
            rightIdx++;
            tempIdx++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int arr1[] = { 6, 3, 9, 5, 2, 8 };
        printArr(mergeSort(arr1, 0, arr1.length - 1));
        int arr2[] = { 2, 1, 9, 7, 4, 6 };
        printArr(mergeSort(arr2, 0, arr2.length - 1));
        int arr3[] = { 20, 60, 55, 15, 45, 30, 72 };
        printArr(mergeSort(arr3, 0, arr3.length - 1));
        int arr4[] = { 2, 4, 6, 1, 3, 9 };
        printArr(mergeSort(arr4, 0, arr4.length - 1));
        int arr5[] = { 10, 15, 20, 10, 45, 65 };
        printArr(mergeSort(arr5, 0, arr5.length - 1));
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}