public class FibonacciSeries {
    public static int fib(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibUsingLoop(int n) {
        if (n == 1) {
            return 1;
        }
        int prev1 = 0;
        int prev2 = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
