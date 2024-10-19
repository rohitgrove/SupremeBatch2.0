import java.util.Arrays;

public class AggrassiveCows {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s = 0;
        int e = stalls[stalls.length - 1] - stalls[0];

        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int stalls[], int k, int mid) {
        // can be place k cows, with at last mid distance between cows.

        int cowsCount = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= mid) {
                cowsCount++;
                if (cowsCount == k) {
                    return true;
                }
                lastPos = stalls[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int stalls[] = { 1, 2, 4, 8, 9 };
        int k = 3;
        int n = stalls.length;
        int ans = solve(n, k, stalls);
        System.out.println(ans);
    }
}