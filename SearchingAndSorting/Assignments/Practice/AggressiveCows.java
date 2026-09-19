import java.util.Arrays;

public class AggressiveCows {
    public static boolean isPossible(int[] stalls, int mid, int k) {
        int lastPos = stalls[0];
        int count = 1;
        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= mid) {
                count++;
                if (count == k) {
                    return true;
                }
                lastPos = stalls[i];
            }
        }

        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int start = 0;
        int end = stalls[stalls.length - 1];
        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (isPossible(stalls, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 0, 3, 4, 7, 10, 9 };
        System.out.println(aggressiveCows(arr1, 4));
        int arr2[] = { 4, 2, 1, 3, 6 };
        System.out.println(aggressiveCows(arr2, 2));
    }
}
