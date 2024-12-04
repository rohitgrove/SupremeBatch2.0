public class ExponentialSearchBetterApproach {
    public static int expoSearch(int arr[], int x) {
        int i = 0;
        int j = 1;
        int n = arr.length;

        while (j < n && arr[j] <= x) {
            i = j ;
            j = j * 2;
        }

        return binarySearch(arr, x, i, Math.min(j, n - 1));
    }

    public static int binarySearch(int arr[], int x, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 11, 13, 14, 15, 56, 70 }, x = 13;
        System.out.println(expoSearch(arr, x));
    }
}
