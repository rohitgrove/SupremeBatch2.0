public class ExponextiolSearchBetterApproach {
    public static int expSearch(int[] arr, int x, int n) {
        if (arr[0] == x) {
            return 0;
        }

        int i = 1;
        int j = 0;
        while (arr[i] < x) {
            j = i;
            i = i * 2;
        }

        return binarySearch(arr, j, i, x);
    }

    public static int binarySearch(int arr[], int s, int e, int x) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 11, 13, 14, 15, 56, 70 };
        int n = arr.length;
        int x = 70;
        int ans = expSearch(arr, x, n);
        System.out.println(ans);
    }
}
