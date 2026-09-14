public class PainterPartition {
    public static int findLargestMinDistance(int[] boards, int n, int m) {
        if (m > n) {
            return -1;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < boards.length; i++) {
            end += boards[i];
        }

        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if (isPossible(boards, m, n, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] boards, int m, int n, int mid) {
        int lengthSum = 0;
        int painter = 1;

        for (int i = 0; i < n; i++) {
            if (lengthSum + boards[i] <= mid) {
                lengthSum += boards[i];
            } else {
                painter++;
                if (painter > m || boards[i] > mid) {
                    return false;
                }
                lengthSum = 0;
                lengthSum += boards[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 20, 30, 40 }, m1 = 2;
        System.out.println(findLargestMinDistance(arr1, arr1.length, m1));
        int arr2[] = { 48, 90 }, m2 = 2;
        System.out.println(findLargestMinDistance(arr2, arr2.length, m2));
    }
}
