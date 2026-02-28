public class MergeSort {
    public static int[] mergeSort(int arr[], int s, int e) {
        if (s >= e) {
            return new int[] { arr[s] };
        }

        int mid = s + (e - s) / 2;

        int left[] = mergeSort(arr, s, mid);
        int right[] = mergeSort(arr, mid + 1, e);
        return merge(left, right);
    }

    public static int[] merge(int left[], int right[]) {
        int ans[] = new int[left.length + right.length];
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while (idx1 < left.length && idx2 < right.length) {
            if (left[idx1] < right[idx2]) {
                ans[idx3] = left[idx1];
                idx1++;
                idx3++;
            } else {
                ans[idx3] = right[idx2];
                idx2++;
                idx3++;
            }
        }

        while (idx1 < left.length) {
            ans[idx3] = left[idx1];
            idx1++;
            idx3++;
        }

        while (idx2 < right.length) {
            ans[idx3] = right[idx2];
            idx2++;
            idx3++;
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
        int arr[] = { 2, 1, 6, 9, 4, 5 };
        printArr(mergeSort(arr, 0, arr.length - 1));
    }
}