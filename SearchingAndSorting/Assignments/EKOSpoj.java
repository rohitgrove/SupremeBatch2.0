public class EKOSpoj {
    public static boolean isPossible(long[] treeHeights, long m, long mid) {
        long woodCollected = 0;
        for (int i = 0; i < treeHeights.length; i++) {
            if (treeHeights[i] > mid) {
                woodCollected += treeHeights[i] - mid;
            }
        }

        return woodCollected >= m;
    }

    public static long maxSawBladeHeight(long treeHeights[], long m) {
        long start = 0, end = 0;
        for (int i = 0; i < treeHeights.length; i++) {
            end = Math.max(end, treeHeights[i]);
        }
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(treeHeights, m, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        long treeHeight1[] = { 20, 15, 10, 17 }, m1 = 7;
        System.out.println(maxSawBladeHeight(treeHeight1, m1)); // output: 15
        long treeHeight2[] = { 4, 42, 40, 46 }, m2 = 20;
        System.out.println(maxSawBladeHeight(treeHeight2, m2)); // output: 36
    }
}
