public class BookAllocation {
    public static int findPages(int[] arr, int n, int m) {
        if (m > n) {
            return -1;
        }
        int s = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int e = sum;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;
        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > m || arr[i] > mid) {
                    return false;
                }
                pageSum = 0;
                pageSum += arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 12, 34, 67, 90 }, n1 = arr1.length, m1 = 2;
        System.out.println(findPages(arr1, n1, m1));
        int arr2[] = { 25, 46, 28, 49, 24 }, n2 = arr2.length, m2 = 4;
        System.out.println(findPages(arr2, n2, m2));
        int arr3[] = { 10, 20, 30, 40 }, n3 = arr3.length, m3 = 2;
        System.out.println(findPages(arr3, n3, m3));
    }
}
