public class Factorial {
    public static int fact(int n) {
        // base case
        if (n == 1 || n == 0) {
            return 1;
        }

        // recursive call
        int ans = n * fact(n - 1);
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
}