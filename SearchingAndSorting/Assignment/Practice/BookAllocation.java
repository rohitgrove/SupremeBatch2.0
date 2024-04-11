public class BookAllocation {
    public static int findPages(int[] arr, int N, int M) {
        if (M > N) {
            return -1;
        }

        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            e += arr[i];
        }

        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (isPossible(arr, M, mid, N)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1; 
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int M, int mid, int N) {
        int student = 1;
        int sumOfPage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sumOfPage + arr[i] <= mid) {
                sumOfPage += arr[i];
            } else {
                student++;
                if (student > M || arr[i] >= mid) {
                    return false;
                }
                sumOfPage = arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 4, arr[] = { 12, 34, 67, 90 }, M = 2;
        System.out.println(findPages(arr, N, M));
    }
}