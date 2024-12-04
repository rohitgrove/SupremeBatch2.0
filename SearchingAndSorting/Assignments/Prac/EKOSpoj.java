public class EKOSpoj {
    public static boolean isPossible(long[] treeHeight, long m, long mid) {
        int woodCollection = 0;
        for (int i = 0; i < treeHeight.length; i++) {
            if (treeHeight[i] > mid) {
                woodCollection += treeHeight[i] - mid;
            }
        }

        return woodCollection >= m;
    }

    public static long maxSawBladeHeight(long treeHeight[], long m) {
        long start = 0, end = 0;
        for (int i = 0; i < treeHeight.length; i++) {
            end = Math.max(end, treeHeight[i]);
        }
        long ans = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(treeHeight, m, mid)) {
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
