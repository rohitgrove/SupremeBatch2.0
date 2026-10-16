public class MaximizTheCutSegments {
    public static int maximizeCuts(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int option1 = 1 + maximizeCuts(n - x, x, y, z);
        int option2 = 1 + maximizeCuts(n - y, x, y, z);
        int option3 = 1 + maximizeCuts(n - z, x, y, z);
        return Math.max(option1, Math.max(option2, option3));
    }

    public static void main(String[] args) {
        int ans = maximizeCuts(4, 2, 1, 1);
        System.out.println(ans);
        ans = maximizeCuts(5, 5, 3, 2);
        System.out.println(ans);
        ans = maximizeCuts(7, 8, 9, 10);
        System.out.println(ans);
        System.out.println(Integer.MIN_VALUE);
    }
}
