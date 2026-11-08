public class CountInversion {
    public static int mergeSort(int arr[], int s, int e, int temp[]) {
        if (s >= e) {
            return 0;
        }

        int mid = s + (e - s) / 2;

        int ans = 0;
        ans += mergeSort(arr, s, mid, temp);
        ans += mergeSort(arr, mid + 1, e, temp);
        ans += merge(arr, s, mid, e, temp);
        return ans;
    }

    public static int merge(int arr[], int s, int mid, int e, int temp[]) {
        int count = 0;
        int i = s,  j = mid + 1, k = s;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1; // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (i = s; i <= e; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

    public static int inversionCount(int arr[]) {
        int s = 0;
        int e = arr.length - 1;
        int temp[] = new int[arr.length];
        return mergeSort(arr, s, e, temp);
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCount(arr1));
        int arr2[] = { 2, 3, 4, 5, 6 };
        System.out.println(inversionCount(arr2));
    }
}
