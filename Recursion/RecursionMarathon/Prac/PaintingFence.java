public class PaintingFence {
    public static int countWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        int ans = (k - 1) * (countWays(n - 1, k) + countWays(n - 2, k));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countWays(2, 4));
        System.out.println(countWays(3, 2));
        System.out.println(countWays(4, 3));
    }
}
