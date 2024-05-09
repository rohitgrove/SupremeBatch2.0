public class PaintingFenceAlgorithm {
    public static int getPaintWays(int n, int k) {
        // base case
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        int same = getPaintWays(n - 2, k) * (k - 1);
        int diff = getPaintWays(n - 1, k) * (k - 1);
        int ans = same + diff;
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        System.out.println(getPaintWays(n, k));
    }
}
