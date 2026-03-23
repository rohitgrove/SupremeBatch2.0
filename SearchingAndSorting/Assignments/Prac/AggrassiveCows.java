import java.util.Arrays;

public class AggrassiveCows {
    public static int aggressiveCows(int stalls[], int k) {
        Arrays.sort(stalls);
        int s = 0;
        int e = stalls[stalls.length - 1];
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] stalls, int k, int mid) {
        int lastStall = stalls[0];
        int cowCount = 1;

        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - lastStall >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }

                lastStall = stalls[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int stalls1[] = { 0, 3, 4, 7, 10, 9 }, k1 = 4;
        System.out.println(aggressiveCows(stalls1, k1));
        int stalls2[] = { 4, 2, 1, 3, 6 }, k2 = 2;
        System.out.println(aggressiveCows(stalls2, k2));
    }
}
