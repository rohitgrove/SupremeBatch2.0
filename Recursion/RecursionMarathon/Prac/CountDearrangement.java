public class CountDearrangement {
    public static int solve(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int ans = (n - 1) * (solve(n - 1) + solve(n - 2));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(2));
        System.out.println(solve(3));
        System.out.println(solve(4));
    }
}