public class CountInversion {
    public static int mergeSort(int arr[], int temp[], int start, int end) {
        if (start>=end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = 0;

        count += mergeSort(arr, temp, start, mid);
        count += mergeSort(arr, temp, mid + 1, end);
        count += merge(arr, temp, start, mid, end);

        return count;
    }

    public static int merge(int arr[], int temp[], int start, int mid, int end) {
        int i = start, j = mid + 1;
        int k = start;
        int count = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                count += mid - i + 1;
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        while (start <= end) {
            arr[start] = temp[start];
            start++;
        }

        return count;
    }

    public static int inversionCountMerge(int arr[]) {
        int temp[] = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCountMerge(arr1));// 3
        int arr2[] = { 2, 3, 4, 5, 6 };
        System.out.println(inversionCountMerge(arr2));// 0
        int arr3[] = { 10, 10, 10 };
        System.out.println(inversionCountMerge(arr3));// 0
        int arr4[] = { 3, 2, 1 };
        System.out.println(inversionCountMerge(arr4));// 3
        int arr5[] = { 2, 5, 1, 3, 4 };
        System.out.println(inversionCountMerge(arr5));// 4
        int arr6[] = { 1, 1, 1, 2, 2 };
        System.out.println(inversionCountMerge(arr6));// 0
        int arr7[] = { 2, 1, 3, 1, 2 };
        System.out.println(inversionCountMerge(arr7));// 4
        int arr8[] = { 8, 4, 2, 1 };
        System.out.println(inversionCountMerge(arr8));// 6
    }
}