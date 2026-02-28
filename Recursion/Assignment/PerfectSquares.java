public class PerfectSquares {
    public static int numSquaresHelper(int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int i = 1;
        int end = (int) Math.sqrt(n);
        while (i <= end) {
            int perfectSquare = i * i;
            int numberOfPerfectSquares = 1 + numSquaresHelper(n - perfectSquare);
            if (numberOfPerfectSquares < ans) {
                ans = numberOfPerfectSquares;
            }
            ++i;
        }

        return ans;
    }

    public static int numSquares(int n) {
        return numSquaresHelper(n) - 1;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
