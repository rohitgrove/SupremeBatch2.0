public class Power {
    public static int pow(int a, int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        int ans = a * pow(a, n - 1);
        return ans;
    }

    public static int pow2(int a, int n) {
        // base case
        if (n == 1) {
            return a;
        }

        int ans = a * pow2(a, n - 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow2(2, 10));
    }
}
