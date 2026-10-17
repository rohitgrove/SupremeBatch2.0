public class CountDearrangement {
    public static int derangeCount(int n) {
        // base case
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int ans = (n - 1) * (derangeCount(n - 1) + derangeCount(n - 2));
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(derangeCount(n));
    }
}
