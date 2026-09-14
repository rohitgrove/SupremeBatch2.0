public class BookAllocation {
    public static int findPages(int[] arr, int n, int m) {
        if (m > n) {
            return -1;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end += arr[i];
        }

        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if (isPossible(arr, m, n, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int m, int n, int mid) {
        int findPages = 0;
        int student = 1;

        for (int i = 0; i < n; i++) {
            if (findPages + arr[i] <= mid) {
                findPages += arr[i];
            } else {
                student++;
                if (student > m || arr[i] > mid) {
                    return false;
                }
                findPages = 0;
                findPages += arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 12, 34, 67, 90 };
        System.out.println(findPages(arr1, arr1.length, 2));
        int arr2[] = { 25, 46, 28, 49, 24 };
        System.out.println(findPages(arr2, arr2.length, 4));
    }
}
