public class PerfectSquares {
    public static int numSqauresHelper(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int i = 1;
        int ans = Integer.MAX_VALUE;
        int end = (int) Math.sqrt(n);
        while (i <= end) {
            int perfectSqaure = i * i;
            int numberOfPerfectSquares = 1 + numSqauresHelper(n - perfectSqaure);
            if (numberOfPerfectSquares < ans) {
                ans = numberOfPerfectSquares;
            }
            ++i;
        }

        return ans;
    }

    public static int numSquares(int n) {
        return numSqauresHelper(n) - 1;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
