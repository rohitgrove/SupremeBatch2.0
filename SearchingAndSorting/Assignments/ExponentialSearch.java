public class ExponentialSearch {
    public static int expoSearch(int arr[], int x) {
        if (arr[0] == x) {
            return 0;
        }
        int i = 1;
        int n = arr.length;

        while (i < n && arr[i] <= x) {
            i = i * 2; // i *= 2 // i = i << 1
        }

        return binarySearch(arr, x, (i / 2), Math.min(i, n - 1));
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
        int arr[] = { 3, 4, 5, 6, 11, 13, 14, 15, 56, 70 }, x = 56;
        System.out.println(expoSearch(arr, x));
    }
}
