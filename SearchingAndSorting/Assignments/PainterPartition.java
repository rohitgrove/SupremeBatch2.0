public class PainterPartition {
    public static int findLargestMinDistance(int boards[], int m) {
        int s = 0;
        int sum = 0;
        for (int i = 0; i < boards.length; i++) {
            sum += boards[i];
        }

        int e = sum;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (isPossible(boards, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] boards, int m, int mid) {
        int painterCount = 1;
        int lengthSum = 0;

        for (int i = 0; i < boards.length; i++) {
            if (boards[i] + lengthSum <= mid) {
                lengthSum += boards[i];
            } else {
                painterCount++;
                if (painterCount > m || boards[i] > mid) {
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
        System.out.println(findLargestMinDistance(arr1, m1));
        int arr2[] = { 48, 90 }, m2 = 2;
        System.out.println(findLargestMinDistance(arr2, m2));
    }
}
